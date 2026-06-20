package iterator.intermediateIterator.advanced;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem 14
 *
 * Implement parallel traversal using Spliterator.
 */
public class ParallelTraversal {

    public static void main(String[] args) {
        // Create a large list of numbers to process.
        List<Integer> numberList = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("--- 1. Manual Parallel Traversal with Spliterator and Threads ---");
        manualParallelTraversal(numberList);

        System.out.println("\n\n--- 2. The Modern & Recommended Way: Parallel Streams ---");
        modernParallelTraversal(numberList);
    }

    /**
     * Demonstrates the low-level mechanics of Spliterator.
     * This approach is for educational purposes to show how splitting works.
     */
    private static void manualParallelTraversal(List<Integer> list) {
        Spliterator<Integer> mainSpliterator = list.spliterator();

        // Attempt to split the main spliterator in half.
        // spliterator1 will cover the first half, and mainSpliterator will now cover the second half.
        Spliterator<Integer> spliterator1 = mainSpliterator.trySplit();

        // We can even split them further for more parallelism
        Spliterator<Integer> spliterator2 = spliterator1.trySplit();
        Spliterator<Integer> spliterator3 = mainSpliterator.trySplit();

        // Now we have 4 spliterators covering different parts of the list.
        // We can process them in separate threads.
        System.out.println("Splitting the work into multiple chunks...");
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new NumberProcessor(spliterator1, "Processor-1"));
        executor.submit(new NumberProcessor(spliterator2, "Processor-2"));
        executor.submit(new NumberProcessor(mainSpliterator, "Processor-3"));
        executor.submit(new NumberProcessor(spliterator3, "Processor-4"));

        // Shutdown the executor and wait for tasks to complete.
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * A simple Runnable that processes elements from a given Spliterator.
     */
    static class NumberProcessor implements Runnable {
        private final Spliterator<Integer> spliterator;
        private final String processorName;

        NumberProcessor(Spliterator<Integer> spliterator, String processorName) {
            this.spliterator = spliterator;
            this.processorName = processorName;
        }

        @Override
        public void run() {
            System.out.println(processorName + " starting work...");
            // forEachRemaining is a convenient way to process all elements.
            spliterator.forEachRemaining(number -> {
                System.out.println(processorName + " processing: " + number);
                try {
                    // Simulate some work
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            System.out.println(processorName + " finished work.");
        }
    }

    /**
     * Demonstrates the easy, efficient, and recommended way to do parallel processing.
     * The Streams API handles all the Spliterator splitting and thread management automatically.
     */
    private static void modernParallelTraversal(List<Integer> list) {
        System.out.println("Using list.parallelStream().forEach() to process elements concurrently.");
        System.out.println("Notice how different threads from the common ForkJoinPool are used:");

        // This single line achieves parallel processing.
        // It uses the list's Spliterator internally to divide the work among
        // threads in the common Fork/Join pool.
        list.parallelStream().forEach(number -> {
            System.out.println(Thread.currentThread().getName() + " is processing number: " + number);
            try {
                // Simulate some work
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
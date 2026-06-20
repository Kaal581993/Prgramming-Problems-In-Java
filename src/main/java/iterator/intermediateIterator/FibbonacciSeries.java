package iterator.intermediateIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Problem 7
 *
 * Create iterable over Fibonacci numbers.
 * 
 * **/
public class FibbonacciSeries implements Iterable<Long> {

    private final int limit;

    /**
     * Constructs a Fibonacci sequence generator.
     * @param limit The total number of Fibonacci numbers to generate.
     */
    public FibbonacciSeries(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit cannot be negative.");
        }
        this.limit = limit;
    }

    /**
     * Returns an iterator that generates Fibonacci numbers on the fly.
     */
    @Override
    public Iterator<Long> iterator() {
        // Return an anonymous inner class that implements the Iterator logic.
        return new Iterator<Long>() {
            private int count = 0;
            // Tracks how many numbers have been generated.
            // Use Long to avoid integer overflow,
            // as Fibonacci numbers grow very quickly.
            private long current = 0;
            private long next = 1;

            /**
             * Checks if we have generated the requested number of elements.
             */
            @Override
            public boolean hasNext() {
                return count < limit;
            }

            /**
             * Generates and returns the next Fibonacci number in the sequence.
             */
            @Override
            public Long next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more Fibonacci numbers to generate.");
                }

                // The core logic to generate the sequence:
                long result = current;
                long sum = current + next;
                current = next;
                next = sum;
                
                count++;
                return result;
            }
        };
    }

    public static void main(String[] args) {
        // Demonstrate generating the first 15 Fibonacci numbers.
        int numberOfFibonacciNumbers = 15;
        System.out.println(
                "Generating the first "
                        + numberOfFibonacciNumbers
                        + " Fibonacci numbers:");

        // Create an instance of our iterable Fibonacci sequence.
        FibbonacciSeries fibonacciSequence = new FibbonacciSeries(numberOfFibonacciNumbers);

        // Use the enhanced for-each loop, which is possible because our class implements Iterable.
        for (long number : fibonacciSequence) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Example with a different limit
        System.out.println("\nGenerating the first 5 Fibonacci numbers:");
        FibbonacciSeries shortSequence = new FibbonacciSeries(5);
        for (long number : shortSequence) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

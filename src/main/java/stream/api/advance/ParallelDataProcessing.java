package stream.api.advance;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelDataProcessing {
    public static void main(String[] args) {
        // Problem 12: Implement parallel data processing.
        System.out.println("Performing a CPU-intensive task in parallel...");

        long startTime = System.currentTimeMillis();

        // Use parallelStream() to process the data across multiple CPU cores.
        double result = IntStream.range(1, 10_000_000)
                .parallel()
                .mapToDouble(n -> Math.sin(n) * Math.cos(n))
                .sum();

        long endTime = System.currentTimeMillis();

        System.out.println("Result: " + result);
        System.out.println("Parallel processing took: " + (endTime - startTime) + " ms");
    }
}

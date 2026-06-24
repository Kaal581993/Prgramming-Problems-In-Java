package patterns.traversal.list.reverse_traversal;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArrayWithStreams {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Original array: " + Arrays.toString(arr));

        // Method 1: Using IntStream.range to traverse in reverse
        System.out.println("\nMethod 1: IntStream.range for reverse traversal:");
        IntStream.range(arr.length - 1, -1)
                .forEach(i -> System.out.print(arr[i] + " "));
        System.out.println();

        // Method 2: Using IntStream.iterate for reverse traversal
        System.out.println("\nMethod 2: IntStream.iterate for reverse traversal:");
        IntStream.iterate(arr.length - 1, i -> i >= 0, i -> i - 1)
                .forEach(i -> System.out.print(arr[i] + " "));
        System.out.println();

        // Method 3: Create reversed array using streams
        System.out.println("\nMethod 3: Create reversed array using streams:");
        int[] reversed = IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - 1 - i])
                .toArray();
        System.out.println("Reversed array: " + Arrays.toString(reversed));

        // Method 4: Using IntStream.rangeClosed
        System.out.println("\nMethod 4: IntStream.rangeClosed for reverse traversal:");
        IntStream.rangeClosed(1, arr.length)
                .map(i -> arr.length - i)
                .forEach(i -> System.out.print(arr[i] + " "));
        System.out.println();
    }
}
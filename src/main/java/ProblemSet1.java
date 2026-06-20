import java.util.*;
import java.util.stream.*;

public class ProblemSet1 {
    public static void main(String[] args) {
        // Use immutable list - perfect for this read-only operation
        List<Integer> numbers = List.of(4, 11, 23, 9, 23, 14, 15, 7);

        Integer secondHighestOdd = numbers.stream()
                .filter(n -> n % 2 != 0)           // Filter odd numbers
                .distinct()                         // Remove duplicates (23 appears twice)
                .sorted(Comparator.reverseOrder())  // Sort descending
                .skip(1)                            // Skip the highest
                .findFirst()                        // Get the second highest
                .orElse(null);

        System.out.println("Second highest odd: " + secondHighestOdd); // Output: 15
    }
}

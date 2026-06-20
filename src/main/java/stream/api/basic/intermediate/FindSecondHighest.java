package stream.api.basic.intermediate;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindSecondHighest {
    public static void main(String[] args) {
        // Problem 8: Find second highest number.
        List<Integer> numbers = List.of(10, 20, 30, 40, 50, 50);

        Optional<Integer> secondHighest = numbers.stream()
                .distinct() // Remove duplicates to handle cases like {50, 50}
                .sorted(Comparator.reverseOrder()) // Sort in descending order
                .skip(1) // Skip the highest element
                .findFirst(); // Get the next one

        secondHighest.ifPresent(n -> System.out.println("The second highest number is: " + n));
    }
}

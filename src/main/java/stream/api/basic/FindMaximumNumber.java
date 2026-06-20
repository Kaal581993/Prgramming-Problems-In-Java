package stream.api.basic;

import java.util.List;
import java.util.Optional;

public class FindMaximumNumber {
    public static void main(String[] args) {
        // Problem 3: Find maximum number.
        List<Integer> numbers = List.of(12, 45, 6, 89, 34, 99, 54);

        // .max() is a terminal operation that returns an Optional.
        Optional<Integer> maxNumber = numbers.stream()
                .max(Integer::compareTo);

        maxNumber.ifPresent(max -> System.out.println("The maximum number is: " + max));
    }
}

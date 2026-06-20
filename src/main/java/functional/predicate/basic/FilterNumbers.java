package functional.predicate.basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterNumbers {
    public static void main(String[] args) {
        // Problem 3: Filter numbers greater than 50.
        Predicate<Integer> isGreaterThan50 = number -> number > 50;

        List<Integer> numbers = Arrays.asList(23, 65, 45, 89, 12, 99);
        System.out.println("Original list: " + numbers);

        List<Integer> filteredNumbers = numbers.stream()
                .filter(isGreaterThan50)
                .collect(Collectors.toList());

        System.out.println("Numbers greater than 50: " + filteredNumbers);
    }
}

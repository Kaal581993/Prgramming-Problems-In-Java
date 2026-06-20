package stream.api.basic;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Problem 5: Remove duplicates using distinct().
        List<Integer> numbersWithDuplicates = List.of(1, 2, 2, 3, 4, 4, 4, 5);

        List<Integer> distinctNumbers = numbersWithDuplicates.stream()
                .distinct() // The distinct() operation returns a stream with unique elements.
                .collect(Collectors.toList());

        System.out.println("Original list: " + numbersWithDuplicates);
        System.out.println("List with duplicates removed: " + distinctNumbers);
    }
}

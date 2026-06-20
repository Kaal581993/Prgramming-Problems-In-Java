package coding.problems.easy.intermediate.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElements {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>(List.of(
                1,2,2,3,4,4
        ));

        List<Integer> duplicateNumList = numList.stream()
                // Create pairs of (element, index) to track positions
                .collect(Collectors.groupingBy(
                        Function.identity(), // Groups by the element itself
                        Collectors.counting() // Counts occurrences of each element
                ))
                // Filter to keep only elements that appear more than once
                .entrySet()
                .stream()
                .filter(
                        entry ->
                                entry.getValue() > 1)  // Keep duplicates only
                .map(Map.Entry::getKey) // Extract the element (key)
                .collect(Collectors.toList()); // Collect to List

        System.out.println("Duplicate numbers are"+duplicateNumList );
    }
}

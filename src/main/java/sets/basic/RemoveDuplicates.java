package sets.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Problem 1: Remove duplicates from List using Set.
        List<String> namesWithDuplicates = new ArrayList<>();
        namesWithDuplicates.add("Alice");
        namesWithDuplicates.add("Bob");
        namesWithDuplicates.add("Charlie");
        namesWithDuplicates.add("Alice");
        namesWithDuplicates.add("David");
        namesWithDuplicates.add("Bob");

        System.out.println("Original list: " + namesWithDuplicates);

        // Using a HashSet to automatically handle duplicates
        Set<String> uniqueNamesSet = new HashSet<>(namesWithDuplicates);

        // Creating a new list from the set
        List<String> namesWithoutDuplicates = new ArrayList<>(uniqueNamesSet);

        System.out.println("List after removing duplicates: " + namesWithoutDuplicates);
    }
}

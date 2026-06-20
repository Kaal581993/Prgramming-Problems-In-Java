package list.basic.intermediate;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("Alice");
        studentNames.add("David");
        studentNames.add("Alice");

        System.out.println("Original list: " + studentNames);

        // Problem 9: Remove duplicates from List.
        Set<String> uniqueNames = new LinkedHashSet<>(studentNames);
        studentNames.clear();
        studentNames.addAll(uniqueNames);

        System.out.println("List with duplicates removed: " + studentNames);
    }
}

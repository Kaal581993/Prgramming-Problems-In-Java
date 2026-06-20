package list.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDuplicateElements {
    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("Alice");
        studentNames.add("David");
        studentNames.add("Eve");
        studentNames.add("Frank");
        studentNames.add("Grace");
        studentNames.add("Heidi");
        studentNames.add("Ivan");
        studentNames.add("Judy");
        studentNames.add("Alice");

        // Problem 4: Count duplicate elements.
        Map<String, Integer> nameCounts = new HashMap<>();
        for (String name : studentNames) {
            nameCounts.put(name, nameCounts.getOrDefault(name, 0) + 1);
        }

        System.out.println("Duplicate elements count:");
        for (Map.Entry<String, Integer> entry : nameCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}

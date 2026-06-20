package list.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 *
 * Problem 1
 *
 * Store 10 student names in List.
 *
 */

public class StoreStudentNames {
    public static void main(String[] args) {
        // Problem 1: Store 10 student names in List.
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("David");
        studentNames.add("Eve");
        studentNames.add("Frank");
        studentNames.add("Grace");
        studentNames.add("Heidi");
        studentNames.add("Ivan");
        studentNames.add("Judy");

        System.out.println("Stored student names: " + studentNames);
    }
}

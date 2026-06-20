package list.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMaximumElement {
    public static void main(String[] args) {
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

        // Problem 3: Find maximum element in List.
        String maxElement = Collections.max(studentNames);
        System.out.println("The maximum element is: " + maxElement);
    }
}

package list.basic.intermediate;

import java.util.ArrayList;
import java.util.List;

public class RotateList {
    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("David");
        studentNames.add("Eve");

        int k = 2;
        System.out.println("Original list: " + studentNames);
        System.out.println("Rotating by " + k + " positions.");

        // Problem 7: Rotate List by K positions.
        if (studentNames.isEmpty() || k <= 0) {
            return;
        }
        k = k % studentNames.size();

        List<String> rotatedList = new ArrayList<>(
                studentNames
                        .subList(
                                studentNames.size() - k,
                                studentNames.size()));
        rotatedList.addAll(
                studentNames.subList(0, studentNames.size() - k));

        System.out.println("Rotated list: " + rotatedList);
    }
}

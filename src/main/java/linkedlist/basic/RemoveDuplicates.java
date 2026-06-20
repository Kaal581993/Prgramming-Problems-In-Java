package linkedlist.basic;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDuplicates {
    // Problem 3: Remove duplicate elements.

    public static void main(String[] args) {
        LinkedList<String> studentNames = new LinkedList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Alice");
        studentNames.add("Charlie");
        studentNames.add("Bob");

        System.out.println("Original list: " + studentNames);

        HashSet<String> uniqueNames = new HashSet<>(studentNames);
        studentNames.clear();
        studentNames.addAll(uniqueNames);

        System.out.println("List with duplicates removed: " + studentNames);
    }
}

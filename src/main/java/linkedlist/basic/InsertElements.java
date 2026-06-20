package linkedlist.basic;

import java.util.LinkedList;

public class InsertElements {
    // Problem 2: Insert element at beginning and end.

    public static void main(String[] args) {
        LinkedList<String> studentNames = new LinkedList<>();
        studentNames.add("Bob");
        studentNames.add("Charlie");

        System.out.println("Original list: " + studentNames);

        // Problem 2: Insert element at beginning and end.
        studentNames.addFirst("Alice");
        studentNames.addLast("David");

        System.out.println("List after adding elements: " + studentNames);
    }
}

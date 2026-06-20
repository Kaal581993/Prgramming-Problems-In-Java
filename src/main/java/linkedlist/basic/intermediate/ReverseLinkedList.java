package linkedlist.basic.intermediate;

import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<String> studentNames = new LinkedList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("David");

        System.out.println("Original list: " + studentNames);

        // Problem 6: Reverse LinkedList manually.
        LinkedList<String> reversedList = new LinkedList<>();
        for (String name : studentNames) {
            reversedList.addFirst(name);
        }

        System.out.println("Reversed list: " + reversedList);
    }
}

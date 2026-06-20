package linkedlist.basic;

import java.util.Iterator;
import java.util.LinkedList;

public class TraverseLinkedList {
    public static void main(String[] args) {
        LinkedList<String> studentNames = new LinkedList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");

        // Problem 4: Traverse using for loop, iterator, and descending iterator.
        System.out.println("Traversing with for loop:");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println(studentNames.get(i));
        }

        System.out.println("\nTraversing with iterator:");
        Iterator<String> iterator = studentNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nTraversing with descending iterator:");
        Iterator<String> descendingIterator = studentNames.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }
    }
}

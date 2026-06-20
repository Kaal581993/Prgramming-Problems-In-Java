package linkedlist.basic;

import java.util.LinkedList;

public class FindMiddleElement {
    // Problem 5: Find middle element.

    public static void main(String[] args) {
        LinkedList<String> studentNames = new LinkedList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("David");
        studentNames.add("Eve");

        System.out.println("Original list: " + studentNames);

        String middleElement = studentNames.get(studentNames.size() / 2);

        System.out.println("The middle element is: " + middleElement);
    }
}

package linkedlist.basic;

import java.util.LinkedList;

public class CreateStudentLinkedList {
    public static void main(String[] args) {
        // Problem 1: Create LinkedList of student names.
        LinkedList<String> studentNames = new LinkedList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("David");
        studentNames.add("Eve");

        System.out.println("Student names in LinkedList: " + studentNames);
    }
}

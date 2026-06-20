package iterator.intermediateIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Problem 8
 *
 * Implement iterable for custom linked list.
 */
public class CustomLinkedList<T> implements Iterable<T> {

    // A private static nested class to represent a node in the linked list.
    // It's static because it doesn't need to access instance members of CustomLinkedList.
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null; // The 'next' is null by default.
        }
    }

    // 'head' is the entry point to our list. If head is null, the list is empty.
    private Node<T> head;

    /**
     * Adds a new element to the end of the linked list.
     * This is a helper method to make it easy to populate our list for testing.
     * @param data The data to add.
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        // If the list is empty, the new node becomes the head.
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, traverse to the end of the list.
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Set the last node's 'next' to our new node.
        current.next = newNode;
    }

    /**
     * This is the core method of the Iterable interface.
     * It returns a new iterator object that knows how to traverse this linked list.
     */
    @Override
    public Iterator<T> iterator() {
        // We return an anonymous inner class that implements the Iterator interface.
        return new Iterator<T>() {
            // The iterator maintains its own state, starting from the head of the list.
            private Node<T> currentNode = head;

            /**
             * Checks if there are more elements to iterate over.
             * In a linked list, this is true if the current node is not null.
             */
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            /**
             * Returns the next element in the list and advances the iterator's position.
             */
            @Override
            public T next() {
                // Adhering to the Iterator contract, throw an exception if next() is called
                // when there are no more elements.
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the list.");
                }

                // 1. Get the data from the current node.
                T data = currentNode.data;
                // 2. Move the iterator to the next node in the sequence.
                currentNode = currentNode.next;
                // 3. Return the retrieved data.
                return data;
            }
        };
    }

    public static void main(String[] args) {
        // Create an instance of our custom linked list for Strings.
        CustomLinkedList<String> fruitList = new CustomLinkedList<>();

        // Add some elements to the list.
        fruitList.add("Apple");
        fruitList.add("Banana");
        fruitList.add("Cherry");
        fruitList.add("Date");

        System.out.println("Iterating over the custom linked list using a for-each loop:");

        // Because our class implements Iterable, we can use it directly in a for-each loop.
        // Java handles calling iterator(), hasNext(), and next() behind the scenes.
        for (String fruit : fruitList) {
            System.out.println(fruit);
        }
        
        // Example with a different type
        CustomLinkedList<Integer> numberList = new CustomLinkedList<>();
        numberList.add(100);
        numberList.add(200);
        
        System.out.println("\nIterating over a list of integers:");
        for(Integer number : numberList) {
            System.out.println(number);
        }
    }
}

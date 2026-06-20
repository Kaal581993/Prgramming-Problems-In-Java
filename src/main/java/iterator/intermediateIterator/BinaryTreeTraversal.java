package iterator.intermediateIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Problem 10
 *
 * Create iterable for binary tree traversal.
 */
public class BinaryTreeTraversal<T extends Comparable<T>> implements Iterable<T> {

    /**
     * A private static nested class for the nodes of the tree.
     * It's generic and holds data, along with references to left and right children.
     */
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> root;

    /**
     * Inserts data into the tree, maintaining the Binary Search Tree property.
     * This is a helper to build a tree for our example.
     * @param data The data to insert.
     */
    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }
        // Use compareTo for generic comparison
        if (data.compareTo(current.data) < 0) {
            current.left = insertRec(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = insertRec(current.right, data);
        }
        // If data is equal, do nothing (no duplicates).
        return current;
    }

    /**
     * The required method from the Iterable interface.
     * @return A new instance of our custom in-order iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new InOrderIterator();
    }

    /**
     * An inner class that implements the Iterator for in-order traversal.
     * Using a Stack is a classic, elegant way to perform in-order traversal iteratively.
     */
    private class InOrderIterator implements Iterator<T> {
        private final Stack<Node<T>> stack = new Stack<>();

        /**
         * The iterator is initialized by pushing all the left-most nodes
         * from the root onto the stack. The node at the top of the stack
         * is the smallest element in the tree.
         */
        public InOrderIterator() {
            pushLeftChildren(root);
        }

        @Override
        public boolean hasNext() {
            // The iteration can continue as long as there are nodes in the stack.
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more nodes in the tree.");
            }

            // 1. Pop the top node. This is the next node in the in-order sequence.
            Node<T> nextNode = stack.pop();

            // 2. Before returning, we must prepare for the *next* call.
            // If the popped node has a right subtree, we need to visit it.
            // We push all the left children of the right child onto the stack.
            if (nextNode.right != null) {
                pushLeftChildren(nextNode.right);
            }

            // 3. Return the data from the popped node.
            return nextNode.data;
        }

        /**
         * A helper method to push a node and all its subsequent left children
         * onto the stack.
         */
        private void pushLeftChildren(Node<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    public static void main(String[] args) {
        // Create a Binary Search Tree of integers.
        BinaryTreeTraversal<Integer> tree = new BinaryTreeTraversal<>();
        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);
        tree.insert(14);
        tree.insert(4);
        tree.insert(7);
        tree.insert(13);

        System.out.println("In-order traversal using the iterator (should be sorted):");

        // Because we implemented Iterable, we can use a for-each loop!
        // Java will automatically use our custom InOrderIterator.
        for (Integer value : tree) {
            System.out.print(value + " ");
        }
        System.out.println();
        // Expected output: 1 3 4 6 7 8 10 13 14 
    }
}
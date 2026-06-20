package queue.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
    public static void main(String[] args) {
        // Problem 2: Reverse first K elements of queue.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        int k = 3;

        System.out.println("Original queue: " + queue);
        System.out.println("Reversing first " + k + " elements.");

        reverseFirstKElements(queue, k);

        System.out.println("Modified queue: " + queue);
    }

    public static void reverseFirstKElements(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        // Push the first k elements into a stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Enqueue the elements from the stack back into the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Move the remaining (size - k) elements to the back of the queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.poll());
        }
    }
}

package queue.basic.intermediate;

import java.util.Stack;

public class QueueUsingStacks<E> {
    private Stack<E> stack1 = new Stack<>(); // For enqueue
    private Stack<E> stack2 = new Stack<>(); // For dequeue

    public void enqueue(E item) {
        stack1.push(item);
        System.out.println(item + " enqueued.");
    }

    public E dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty.");
                return null;
            }
            // Move elements from stack1 to stack2 to reverse the order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        E item = stack2.pop();
        System.out.println(item + " dequeued.");
        return item;
    }

    public static void main(String[] args) {
        // Problem 10: Implement queue using stacks.
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue(); // Should be 10
        queue.enqueue(30);
        queue.dequeue(); // Should be 20
        queue.dequeue(); // Should be 30
        queue.dequeue(); // Should be empty
    }
}

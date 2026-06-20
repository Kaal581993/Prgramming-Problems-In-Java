package linkedlist.basic.intermediate;

import java.util.LinkedList;

public class QueueUsingLinkedList<E> {
    private LinkedList<E> queue = new LinkedList<>();

    public void enqueue(E element) {
        queue.addLast(element);
        System.out.println("Enqueued: " + element);
    }

    public E dequeue() {
        E element = queue.removeFirst();
        System.out.println("Dequeued: " + element);
        return element;
    }

    public E peek() {
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        // Problem 10: Implement Queue using LinkedList.
        QueueUsingLinkedList<String> queue = new QueueUsingLinkedList<>();
        queue.enqueue("Task 1");
        queue.enqueue("Task 2");
        queue.enqueue("Task 3");
        queue.dequeue();
        System.out.println("Front of queue: " + queue.peek());
    }
}

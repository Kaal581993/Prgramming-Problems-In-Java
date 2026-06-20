package queue.basic.intermediate;

public class CircularQueue {
    private int[] arr;
    private int front, rear, size;
    private final int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = this.size = 0;
        rear = capacity - 1;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.arr[this.rear] = item;
        this.size++;
        System.out.println(item + " enqueued to queue");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return Integer.MIN_VALUE;
        }
        int item = this.arr[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return item;
    }

    public static void main(String[] args) {
        // Problem 6: Implement circular queue.
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Should be full

        System.out.println(queue.dequeue() + " dequeued from queue");
        queue.enqueue(60);
        System.out.println("Front item is " + queue.arr[queue.front]);
        System.out.println("Rear item is " + queue.arr[queue.rear]);
    }
}

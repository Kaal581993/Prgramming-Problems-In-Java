package queue.basic.intermediate.advance;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<E> {
    private Queue<E> queue;
    private int capacity;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public BlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void enqueue(E item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println("Queue is full. Producer is waiting...");
                notFull.await();
            }
            queue.add(item);
            System.out.println("Produced: " + item);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Queue is empty. Consumer is waiting...");
                notEmpty.await();
            }
            E item = queue.poll();
            System.out.println("Consumed: " + item);
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // Problem 11: Implement blocking queue.
        BlockingQueue<Integer> bq = new BlockingQueue<>(2);

        Thread producer = new Thread(() -> {
            try {
                bq.enqueue(1);
                bq.enqueue(2);
                bq.enqueue(3); // This will block until an item is consumed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(2000); // Let producer fill the queue
                bq.dequeue();
                bq.dequeue();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}

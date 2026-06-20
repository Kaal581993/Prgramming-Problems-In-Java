package queue.basic.intermediate.advance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// This simulates a message broker like RabbitMQ or Kafka
class MessageBroker {
    // A real distributed queue would be on a separate server, not in memory
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void submitTask(String task) {
        try {
            queue.put(task);
            System.out.println("Task submitted: " + task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getTask() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}

// Simulates a service that produces tasks
class TaskProducer implements Runnable {
    private final MessageBroker broker;

    public TaskProducer(MessageBroker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String task = "Task-" + i + " from " + Thread.currentThread().getName();
            broker.submitTask(task);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Simulates a worker service that consumes and processes tasks
class TaskConsumer implements Runnable {
    private final MessageBroker broker;

    public TaskConsumer(MessageBroker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        while (true) {
            String task = broker.getTask();
            if (task != null) {
                System.out.println(Thread.currentThread().getName() + " processed: " + task);
            }
        }
    }
}

public class DistributedTaskQueue {
    public static void main(String[] args) {
        // Problem 12: Implement distributed task queue (conceptual).
        MessageBroker broker = new MessageBroker();

        // Start multiple producers and consumers to simulate a distributed system
        Thread producer1 = new Thread(new TaskProducer(broker), "Producer-1");
        Thread consumer1 = new Thread(new TaskConsumer(broker), "Consumer-1");
        Thread consumer2 = new Thread(new TaskConsumer(broker), "Consumer-2");

        producer1.start();
        consumer1.start();
        consumer2.start();
    }
}

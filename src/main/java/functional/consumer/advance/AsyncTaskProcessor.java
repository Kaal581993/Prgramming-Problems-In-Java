package functional.consumer.advance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

public class AsyncTaskProcessor<T> implements Runnable {
    private final BlockingQueue<T> taskQueue = new LinkedBlockingQueue<>();
    private final Consumer<T> taskConsumer;
    private volatile boolean isRunning = true;

    public AsyncTaskProcessor(Consumer<T> taskConsumer) {
        this.taskConsumer = taskConsumer;
    }

    public void submit(T task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning || !taskQueue.isEmpty()) {
            try {
                T task = taskQueue.take();
                taskConsumer.accept(task);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("Task processor has shut down.");
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 12: Implement async task processor.
        
        // Define the work to be done for each task (e.g., sending an email)
        Consumer<String> emailSender = email -> {
            System.out.println("Sending email to: " + email);
            try { Thread.sleep(1000); } catch (InterruptedException e) {} // Simulate work
        };

        AsyncTaskProcessor<String> processor = new AsyncTaskProcessor<>(emailSender);
        Thread processorThread = new Thread(processor);
        processorThread.start();

        // Submit tasks from the main thread
        processor.submit("alice@example.com");
        processor.submit("bob@example.com");

        Thread.sleep(3000);
        processor.stop();
        processorThread.join();
    }
}

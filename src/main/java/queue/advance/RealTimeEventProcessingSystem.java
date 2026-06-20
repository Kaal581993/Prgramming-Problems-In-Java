package queue.advance;

import java.time.Instant;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

// Represents a single event in the stream
class Event {
    private final String type;
    private final String data;
    private final Instant timestamp;

    public Event(String type, String data) {
        this.type = type;
        this.data = data;
        this.timestamp = Instant.now();
    }

    @Override
    public String toString() {
        return "Event{" + "type='" + type + '\'' + ", data='" + data + '\'' + ", timestamp=" + timestamp + '}';
    }
}

// Simulates a source of real-time events (e.g., user clicks, sensor readings)
class EventSource implements Runnable {
    private final BlockingQueue<Event> eventQueue;

    public EventSource(BlockingQueue<Event> eventQueue) {
        this.eventQueue = eventQueue;
    }

    @Override
    public void run() {
        String[] eventTypes = {"click", "login", "purchase", "logout"};
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String type = eventTypes[ThreadLocalRandom.current().nextInt(eventTypes.length)];
                String data = "user-" + ThreadLocalRandom.current().nextInt(1000);
                Event event = new Event(type, data);
                eventQueue.put(event);
                System.out.println("Generated Event: " + event.toString());
                Thread.sleep(ThreadLocalRandom.current().nextLong(500, 2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Consumes events from the queue and processes them
class EventProcessor implements Runnable {
    private final BlockingQueue<Event> eventQueue;
    private final String processorId;

    public EventProcessor(BlockingQueue<Event> eventQueue, String processorId) {
        this.eventQueue = eventQueue;
        this.processorId = processorId;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Event event = eventQueue.take();
                System.out.println("[" + processorId + "] Processing Event: " + event.toString());
                // In a real system, this is where you'd have business logic,
                // like updating a dashboard, checking for fraud, etc.
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class RealTimeEventProcessingSystem {
    public static void main(String[] args) {
        // Problem 15: Build real-time event processing system.
        BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<>(10);

        // Start the source of events
        Thread eventSource = new Thread(new EventSource(eventQueue));
        eventSource.start();

        // Start multiple processors to handle events concurrently
        Thread processor1 = new Thread(new EventProcessor(eventQueue, "Processor-1"));
        Thread processor2 = new Thread(new EventProcessor(eventQueue, "Processor-2"));
        processor1.start();
        processor2.start();
    }
}

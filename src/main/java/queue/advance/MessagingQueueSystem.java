package queue.advance;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

class MessageBroker {
    private final Map<String, BlockingQueue<String>> topics = new ConcurrentHashMap<>();

    public void createTopic(String topicName) {
        topics.putIfAbsent(topicName, new LinkedBlockingQueue<>());
        System.out.println("Topic created: " + topicName);
    }

    public void publish(String topicName, String message) {
        BlockingQueue<String> topicQueue = topics.get(topicName);
        if (topicQueue == null) {
            System.out.println("Error: Topic '" + topicName + "' does not exist.");
            return;
        }
        try {
            topicQueue.put(message);
            System.out.println("Published to '" + topicName + "': " + message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String consume(String topicName) {
        BlockingQueue<String> topicQueue = topics.get(topicName);
        if (topicQueue == null) {
            System.out.println("Error: Topic '" + topicName + "' does not exist.");
            return null;
        }
        try {
            return topicQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}

class Publisher implements Runnable {
    private final MessageBroker broker;
    private final String topic;

    public Publisher(MessageBroker broker, String topic) {
        this.broker = broker;
        this.topic = topic;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            broker.publish(topic, "Message-" + i);
            try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}

class Subscriber implements Runnable {
    private final MessageBroker broker;
    private final String topic;
    private final String name;

    public Subscriber(MessageBroker broker, String topic, String name) {
        this.broker = broker;
        this.topic = topic;
        this.name = name;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            String message = broker.consume(topic);
            System.out.println(name + " consumed from '" + topic + "': " + message);
        }
    }
}

public class MessagingQueueSystem {
    public static void main(String[] args) {
        // Problem 14: Implement messaging queue system.
        MessageBroker broker = new MessageBroker();
        broker.createTopic("news");
        broker.createTopic("sports");

        Thread newsPublisher = new Thread(new Publisher(broker, "news"));
        Thread sportsPublisher = new Thread(new Publisher(broker, "sports"));

        Thread newsSubscriber1 = new Thread(new Subscriber(broker, "news", "NewsSubscriber-1"));
        Thread sportsSubscriber1 = new Thread(new Subscriber(broker, "sports", "SportsSubscriber-1"));

        newsPublisher.start();
        sportsPublisher.start();
        newsSubscriber1.start();
        sportsSubscriber1.start();
    }
}

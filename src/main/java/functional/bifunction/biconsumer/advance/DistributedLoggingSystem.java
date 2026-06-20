package functional.bifunction.biconsumer.advance;

import java.util.function.BiConsumer;

// Simulates a client that sends logs to a distributed system like Kafka or RabbitMQ
class LogApiClient {
    public void send(String topic, String message) {
        // In a real system, this would involve a network call.
        System.out.println("LOG_API -> Topic: '" + topic + "', Message: '" + message + "'");
    }
}

public class DistributedLoggingSystem {
    private final LogApiClient apiClient;

    public DistributedLoggingSystem(LogApiClient client) {
        this.apiClient = client;
    }

    // This BiConsumer provides a clean interface for logging.
    public BiConsumer<String, String> getLogger() {
        return apiClient::send;
    }

    public static void main(String[] args) {
        // Problem 14: Build distributed logging system.
        LogApiClient client = new LogApiClient();
        DistributedLoggingSystem loggingSystem = new DistributedLoggingSystem(client);

        BiConsumer<String, String> logger = loggingSystem.getLogger();

        // Log different types of events to different topics
        logger.accept("audit_logs", "User 'admin' logged in.");
        logger.accept("error_logs", "NullPointerException at line 52.");
    }
}

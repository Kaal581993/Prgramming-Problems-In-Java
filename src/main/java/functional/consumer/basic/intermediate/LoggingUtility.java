package functional.consumer.basic.intermediate;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public class LoggingUtility {

    // A consumer that logs a message to the console with a timestamp.
    public static final Consumer<String> CONSOLE_LOGGER = message ->
            System.out.println("[" + LocalDateTime.now() + "] " + message);

    // A consumer that might log to a file or another service (simulated here).
    public static final Consumer<String> FILE_LOGGER = message ->
            System.out.println("FILE_LOG: " + message);


    public static void main(String[] args) {
        // Problem 6: Build logging utility using Consumer.

        // Log a simple message to the console
        CONSOLE_LOGGER.accept("Application started.");

        // Create a multi-logger that logs to both console and file
        Consumer<String> multiLogger = CONSOLE_LOGGER.andThen(FILE_LOGGER);

        multiLogger.accept("An important event occurred.");
    }
}

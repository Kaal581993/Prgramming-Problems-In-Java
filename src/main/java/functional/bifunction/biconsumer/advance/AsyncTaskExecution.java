package functional.bifunction.biconsumer.advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

class Task<T, U> {
    T param1;
    U param2;
    public Task(T p1, U p2) { param1 = p1; param2 = p2; }
}

public class AsyncTaskExecution {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public <T, U> void execute(BiConsumer<T, U> action, T param1, U param2) {
        executor.submit(() -> action.accept(param1, param2));
    }

    public void shutdown() {
        executor.shutdown();
    }

    public static void main(String[] args) {
        // Problem 12: Implement async task execution.
        AsyncTaskExecution asyncEngine = new AsyncTaskExecution();

        // Define a task that processes a user and a file (simulated)
        BiConsumer<String, String> fileProcessor = (username, filename) -> {
            System.out.println("User '" + username + "' started processing file '" + filename + "'...");
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            System.out.println("Finished processing file: " + filename);
        };

        System.out.println("Submitting tasks...");
        asyncEngine.execute(fileProcessor, "user1", "report.csv");
        asyncEngine.execute(fileProcessor, "user2", "data.json");

        asyncEngine.shutdown();
    }
}

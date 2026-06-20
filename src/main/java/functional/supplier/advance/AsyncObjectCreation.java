package functional.supplier.advance;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

class HeavyResource {
    public HeavyResource() {
        System.out.println("Starting creation of HeavyResource... (will take 3 seconds)");
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        System.out.println("HeavyResource created.");
    }
    public String getData() { return "Some heavy data"; }
}

public class AsyncObjectCreation {

    public static <T> CompletableFuture<T> createAsync(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier);
    }

    public static void main(String[] args) {
        // Problem 14: Implement async object creation system.
        System.out.println("Main thread: Requesting HeavyResource creation asynchronously.");

        // The supplier defines how to create the object.
        // CompletableFuture.supplyAsync runs it in a background thread.
        CompletableFuture<HeavyResource> futureResource = createAsync(HeavyResource::new);

        System.out.println("Main thread: Continuing with other work...");

        // We can chain actions to be performed when the object is ready.
        futureResource.thenAccept(resource -> {
            System.out.println("Main thread: Resource is ready! Data: " + resource.getData());
        });

        // Keep the main thread alive to see the result.
        try { Thread.sleep(4000); } catch (InterruptedException e) {}
    }
}

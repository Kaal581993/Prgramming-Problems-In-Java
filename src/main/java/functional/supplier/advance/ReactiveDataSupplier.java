package functional.supplier.advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

// A source that supplies data asynchronously
class DataSource<T> {
    private final Supplier<T> supplier;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public DataSource(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public void subscribe(Consumer<T> onData) {
        executor.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                onData.accept(supplier.get());
                try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
            }
        });
    }

    public void stop() {
        executor.shutdownNow();
    }
}

public class ReactiveDataSupplier {
    public static void main(String[] args) throws InterruptedException {
        // Problem 13: Create reactive data supplier.
        
        // A supplier that provides real-time stock prices (simulated)
        Supplier<Double> stockPriceSupplier = () -> 100.0 + (Math.random() * 10 - 5);

        DataSource<Double> stockTicker = new DataSource<>(stockPriceSupplier);

        // A consumer that reacts to the data
        Consumer<Double> priceDisplay = price -> System.out.printf("Current Stock Price: $%.2f%n", price);

        System.out.println("Subscribing to stock ticker...");
        stockTicker.subscribe(priceDisplay);

        // Let it run for 5 seconds
        Thread.sleep(5000);
        stockTicker.stop();
        System.out.println("Subscription ended.");
    }
}

package functional.bifunction.biconsumer.intermediate;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

public class ProcessInvoiceItems {
    public static void main(String[] args) {
        // Problem 9: Process invoice items.
        Map<String, Double> items = Map.of("Item A", 19.99, "Item B", 49.99, "Item C", 5.49);
        
        // We use AtomicReference because variables used in lambdas must be final or effectively final.
        AtomicReference<Double> total = new AtomicReference<>(0.0);

        // This BiConsumer adds the item's price to the total.
        BiConsumer<String, Double> calculateTotal = (itemName, price) -> {
            System.out.println("Processing " + itemName + " - $" + price);
            total.updateAndGet(currentTotal -> currentTotal + price);
        };

        items.forEach(calculateTotal);

        System.out.printf("Final Invoice Total: $%.2f%n", total.get());
    }
}

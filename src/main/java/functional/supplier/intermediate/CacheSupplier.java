package functional.supplier.intermediate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

class DataCache<K, V> {
    private final Map<K, V> cache = new HashMap<>();

    // This method returns a Supplier that will get a value from the cache,
    // or compute and store it if it's not present.
    public Supplier<V> getOrCompute(K key, Supplier<V> valueSupplier) {
        return () -> cache.computeIfAbsent(key, k -> {
            System.out.println("Value for key '" + k + "' not in cache. Computing...");
            return valueSupplier.get();
        });
    }
}

public class CacheSupplier {
    public static void main(String[] args) {
        // Problem 9: Create reusable cache supplier.
        DataCache<String, String> cache = new DataCache<>();

        // Supplier to fetch data for "user:1" (simulates a slow DB call)
        Supplier<String> user1DataSupplier = () -> {
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            return "Alice's Profile Data";
        };

        // Get a supplier that wraps the caching logic
        Supplier<String> cachedUser1Supplier = cache.getOrCompute("user:1", user1DataSupplier);

        // First call: computes and caches the value
        System.out.println("First access: " + cachedUser1Supplier.get());

        // Second call: returns the cached value instantly
        System.out.println("Second access: " + cachedUser1Supplier.get());
    }
}

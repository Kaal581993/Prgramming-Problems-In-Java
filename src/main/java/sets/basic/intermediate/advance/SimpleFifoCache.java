package sets.basic.intermediate.advance;

import java.util.LinkedHashSet;

public class SimpleFifoCache<K> {
    private final int capacity;
    private final LinkedHashSet<K> cache;

    public SimpleFifoCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashSet<>(capacity);
    }

    public boolean get(K key) {
        return cache.contains(key);
    }

    public void put(K key) {
        if (cache.contains(key)) {
            // If you want to move it to the end (for LRU-like behavior), you'd remove and re-add
            // For FIFO, we do nothing.
            System.out.println("Key '" + key + "' is already in the cache.");
            return;
        }

        if (cache.size() >= capacity) {
            // Evict the first element added (First-In, First-Out)
            K oldestKey = cache.iterator().next();
            cache.remove(oldestKey);
            System.out.println("Cache is full. Evicting oldest key: " + oldestKey);
        }
        cache.add(key);
        System.out.println("Added key to cache: " + key);
    }

    public void displayCache() {
        System.out.println("Current cache state (FIFO order): " + cache);
    }

    public static void main(String[] args) {
        // Problem 12: Build caching system using LinkedHashSet (FIFO example).
        SimpleFifoCache<String> cache = new SimpleFifoCache<>(3);
        cache.put("A");
        cache.put("B");
        cache.put("C");
        cache.displayCache();

        cache.put("A"); // No change for FIFO
        cache.displayCache();

        cache.put("D"); // Evicts "A"
        cache.displayCache();
    }
}

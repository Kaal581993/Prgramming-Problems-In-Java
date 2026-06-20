package map.basic.intermediate;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        // The 'true' for accessOrder is what makes it an LRU cache
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // This method is called after a new entry is added.
        // If it returns true, the eldest entry is removed.
        return size() > capacity;
    }

    public static void main(String[] args) {
        // Problem 6: Implement LRU cache using LinkedHashMap.
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println("Initial cache: " + cache);

        cache.get(1); // Accessing 1 makes it the most recently used
        System.out.println("After accessing 1: " + cache);

        cache.put(4, "Four"); // This should evict the least recently used entry (2)
        System.out.println("After adding 4: " + cache);
    }
}

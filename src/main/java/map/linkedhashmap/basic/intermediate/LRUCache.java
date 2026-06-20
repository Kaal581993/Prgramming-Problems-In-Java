package map.linkedhashmap.basic.intermediate;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        // The 'true' argument for accessOrder is the key to making this an LRU cache.
        // It orders elements from least-recently accessed to most-recently accessed.
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // This method is invoked by put and putAll after inserting a new entry.
        // It returns true if the eldest entry should be removed.
        return size() > capacity;
    }

    public static void main(String[] args) {
        // Problem 6: Implement LRU cache using LinkedHashMap.
        // This is the classic, most efficient way to implement an LRU cache in Java.
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println("Initial cache: " + cache);

        cache.get(1); // Accessing 1 moves it to the end (most recent).
        System.out.println("After accessing 1: " + cache);

        cache.put(4, "Four"); // This should evict the eldest entry (2).
        System.out.println("After adding 4: " + cache);
    }
}

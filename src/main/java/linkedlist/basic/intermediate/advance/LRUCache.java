package linkedlist.basic.intermediate.advance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final LinkedList<K> lru;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lru = new LinkedList<>();
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            lru.remove(key);
            lru.addFirst(key);
            return cache.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            lru.remove(key);
        } else if (cache.size() >= capacity) {
            K leastRecentlyUsed = lru.removeLast();
            cache.remove(leastRecentlyUsed);
        }
        cache.put(key, value);
        lru.addFirst(key);
    }

    public static void main(String[] args) {
        // Problem 12: Implement LRU cache.
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");
        System.out.println("Cache: " + lruCache.cache);

        lruCache.get(1); // Accessing 1, making it most recently used.
        System.out.println("Cache after getting 1: " + lruCache.cache);

        lruCache.put(4, "Four"); // This should evict 2.
        System.out.println("Cache after adding 4: " + lruCache.cache);
    }
}

package map.concurrenthashmap.intermediate;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LRUCache<K, V> {
    private final int capacity;
    private final ConcurrentHashMap<K, V> cache;
    private final Queue<K> lruQueue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>(capacity);
        this.lruQueue = new ConcurrentLinkedQueue<>();
    }

    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            // Move to the end of the queue to mark as recently used
            lruQueue.remove(key);
            lruQueue.add(key);
        }
        return value;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            lruQueue.remove(key);
        }
        
        while (lruQueue.size() >= capacity) {
            K oldestKey = lruQueue.poll();
            if (oldestKey != null) {
                cache.remove(oldestKey);
            }
        }
        
        lruQueue.add(key);
        cache.put(key, value);
    }

    public static void main(String[] args) {
        // Problem 6: Implement thread-safe LRU cache using ConcurrentHashMap.
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.get(1); // 1 is now most recently used
        cache.put(3, "Three"); // Should evict 2

        System.out.println("Cache state: " + cache.cache);
    }
}

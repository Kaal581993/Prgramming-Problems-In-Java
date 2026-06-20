package list.basic.intermediate.advance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {

    // Problem 15: Design LRU Cache using LinkedList.

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
            System.out.println(lru);
            lru.addFirst(key);
            System.out.println(lru);
            System.out.println(cache);
            return cache.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            lru.remove(key);
            System.out.println(lru);
        } else if (cache.size() >= capacity) {
            K leastRecentlyUsed = lru.removeLast();
            System.out.println(leastRecentlyUsed);
            cache.remove(leastRecentlyUsed);
            System.out.println(cache);
        }
        cache.put(key, value);
        System.out.println(cache);
        lru.addFirst(key);
        System.out.println(lru);
    }

    public static void main(String[] args) {
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

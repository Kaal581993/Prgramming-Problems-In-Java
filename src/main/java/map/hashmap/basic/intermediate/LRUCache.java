package map.hashmap.basic.intermediate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final LinkedList<K> lruOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.lruOrder = new LinkedList<>();
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            // Move the accessed key to the front of the list to mark it as recently used
            lruOrder.remove(key);
            lruOrder.addFirst(key);
            return cache.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            // If key exists, just update the value and move it to the front
            lruOrder.remove(key);
        } else if (cache.size() >= capacity) {
            // Evict the least recently used item (at the end of the list)
            K lruKey = lruOrder.removeLast();
            cache.remove(lruKey);
            System.out.println("Cache full. Evicting: " + lruKey);
        }
        cache.put(key, value);
        lruOrder.addFirst(key);
    }

    public static void main(String[] args) {
        // Problem 6: Implement LRU cache using HashMap and LinkedList.
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println("Cache state: " + cache.lruOrder);

        cache.get(1); // Access 1
        System.out.println("After getting 1: " + cache.lruOrder);

        cache.put(4, "Four"); // Should evict 2
        System.out.println("After adding 4: " + cache.lruOrder);
    }
}

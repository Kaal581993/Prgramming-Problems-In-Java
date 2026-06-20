package map.treemap.basic.intermediate;

import java.util.Map;
import java.util.TreeMap;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // TreeMap is not suitable for LRU cache as it sorts by key, not access order.
        // This implementation is for demonstration purposes only.
        this.cache = new TreeMap<>();
    }

    public V get(K key) {
        // In a real LRU cache, a get operation would mark the item as recently used.
        // TreeMap doesn't support this directly.
        return cache.get(key);
    }

    public void put(K key, V value) {
        if (cache.size() >= capacity && !cache.containsKey(key)) {
            // To evict, we have to remove an element. In a TreeMap, we can remove the
            // first or last key, but this is not LRU behavior.
            // This demonstrates the unsuitability of TreeMap for LRU.
            K firstKey = ((TreeMap<K, V>) cache).firstKey();
            cache.remove(firstKey);
            System.out.println("Cache full. Evicting first key (not LRU): " + firstKey);
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        // Problem 6: Implement LRU cache using TreeMap (demonstrating unsuitability).
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(3, "Three");
        cache.put(1, "One");
        cache.put(2, "Two");
        System.out.println("Cache state: " + cache.cache);

        cache.get(3); // This does not change the order in a TreeMap.
        System.out.println("After getting 3: " + cache.cache);

        cache.put(4, "Four"); // Evicts the first key (1), not the least recently used.
        System.out.println("After adding 4: " + cache.cache);
    }
}

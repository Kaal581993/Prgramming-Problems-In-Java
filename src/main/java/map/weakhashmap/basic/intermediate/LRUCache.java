package map.weakhashmap.basic.intermediate;

import java.util.Map;
import java.util.WeakHashMap;

public class LRUCache<K, V> {
    // WeakHashMap is NOT suitable for an LRU cache.
    // Eviction is based on GC, not on access patterns (Least Recently Used).
    // This implementation is purely for demonstrating its behavior.
    private final Map<K, V> cache = new WeakHashMap<>();

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public int size() {
        return cache.size();
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 6: "Implement" LRU cache using WeakHashMap (demonstrating unsuitability).
        LRUCache<Object, String> cache = new LRUCache<>();
        Object key1 = new Object();
        Object key2 = new Object();
        cache.put(key1, "Data for key 1");
        cache.put(key2, "Data for key 2");

        System.out.println("Cache size before GC: " + cache.size());

        key1 = null; // Remove strong reference to key1
        System.gc();
        Thread.sleep(100);

        // The cache size will likely become 1, but this is due to GC, not an LRU policy.
        System.out.println("Cache size after GC: " + cache.size());
    }
}

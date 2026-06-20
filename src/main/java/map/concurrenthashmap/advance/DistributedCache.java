package map.concurrenthashmap.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// A cache node using ConcurrentHashMap for thread-safe local storage
class CacheNode<K, V> {
    private final String nodeId;
    private final Map<K, V> cache = new ConcurrentHashMap<>();

    public CacheNode(String nodeId) { this.nodeId = nodeId; }
    public V get(K key) { return cache.get(key); }
    public void put(K key, V value) { cache.put(key, value); }
}

public class DistributedCache<K, V> {
    private final List<CacheNode<K, V>> nodes;
    private final int numberOfNodes;

    public DistributedCache(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        this.nodes = new ArrayList<>(numberOfNodes);
        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(new CacheNode<>("Node-" + i));
        }
    }

    private CacheNode<K, V> getNodeForKey(K key) {
        return nodes.get(Math.abs(key.hashCode()) % numberOfNodes);
    }

    public void put(K key, V value) { getNodeForKey(key).put(key, value); }
    public V get(K key) { return getNodeForKey(key).get(key); }

    public static void main(String[] args) {
        // Problem 12: Design distributed cache system using ConcurrentHashMap.
        // This is the most practical implementation for thread-safe cache nodes.
        DistributedCache<String, String> distributedCache = new DistributedCache<>(3);

        // Simulate concurrent writes to the cache
        new Thread(() -> distributedCache.put("user:1", "Data 1")).start();
        new Thread(() -> distributedCache.put("user:2", "Data 2")).start();
    }
}

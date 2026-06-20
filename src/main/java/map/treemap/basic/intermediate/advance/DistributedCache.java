package map.treemap.basic.intermediate.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// A cache node using TreeMap for sorted key storage
class CacheNode<K, V> {
    private final String nodeId;
    // TreeMap offers O(log n) for get/put, but allows for ordered scanning.
    private final Map<K, V> cache = new TreeMap<>();

    public CacheNode(String nodeId) { this.nodeId = nodeId; }
    public V get(K key) { return cache.get(key); }
    public void put(K key, V value) { cache.put(key, value); }
    public Map<K, V> getSortedData() { return cache; }
}

public class DistributedCache<K extends Comparable<K>, V> {
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
        // Problem 12: Design distributed cache system using TreeMap.
        // Useful if nodes require ordered key scanning.
        DistributedCache<String, String> distributedCache = new DistributedCache<>(2);

        distributedCache.put("user:charlie", "Data for charlie");
        distributedCache.put("user:alice", "Data for alice");
        distributedCache.put("user:bob", "Data for bob");

        // Get the node for "user:alice" and display its sorted data
        CacheNode<String, String> node = distributedCache.getNodeForKey("user:alice");
        System.out.println("Data in " + node.nodeId + " (sorted): " + node.getSortedData());
    }
}

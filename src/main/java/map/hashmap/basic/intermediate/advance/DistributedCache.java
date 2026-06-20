package map.hashmap.basic.intermediate.advance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Simulates a single node (or shard) in the distributed cache
class CacheNode<K, V> {
    private final String nodeId;
    // Each node uses a simple HashMap for its local storage.
    private final Map<K, V> cache = new HashMap<>();

    public CacheNode(String nodeId) {
        this.nodeId = nodeId;
    }

    public V get(K key) {
        System.out.println("[" + nodeId + "] Accessing key: " + key);
        return cache.get(key);
    }

    public void put(K key, V value) {
        System.out.println("[" + nodeId + "] Storing key: " + key);
        cache.put(key, value);
    }
}

// Manages the cluster of cache nodes
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

    // A simple routing strategy to determine which node gets the key
    private CacheNode<K, V> getNodeForKey(K key) {
        int nodeIndex = Math.abs(key.hashCode()) % numberOfNodes;
        return nodes.get(nodeIndex);
    }

    public V get(K key) {
        return getNodeForKey(key).get(key);
    }

    public void put(K key, V value) {
        getNodeForKey(key).put(key, value);
    }

    public static void main(String[] args) {
        // Problem 12: Design distributed cache system using HashMap.
        DistributedCache<String, String> distributedCache = new DistributedCache<>(4); // 4 shards

        distributedCache.put("user:101", "Data for user 101");
        distributedCache.put("product:202", "Data for product 202");
        distributedCache.put("session:303", "Data for session 303");

        System.out.println("\nFetching 'product:202': " + distributedCache.get("product:202"));
    }
}

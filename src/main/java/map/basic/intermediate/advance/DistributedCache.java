package map.basic.intermediate.advance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// This class simulates a single cache node/shard in a distributed system
class CacheNode<K, V> {
    private final String nodeId;
    private final Map<K, V> cache = new ConcurrentHashMap<>();

    public CacheNode(String nodeId) {
        this.nodeId = nodeId;
    }

    public V get(K key) {
        System.out.println("[" + nodeId + "] Getting key: " + key);
        return cache.get(key);
    }

    public void put(K key, V value) {
        System.out.println("[" + nodeId + "] Putting key: " + key);
        cache.put(key, value);
    }
}

// This class manages the different cache nodes and routes requests
public class DistributedCache<K, V> {
    private final CacheNode<K, V>[] nodes;
    private final int numberOfNodes;

    @SuppressWarnings("unchecked")
    public DistributedCache(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        this.nodes = new CacheNode[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            nodes[i] = new CacheNode<>("Node-" + i);
        }
    }

    // Simple routing strategy based on key's hash code
    private CacheNode<K, V> getNodeForKey(K key) {
        int nodeIndex = Math.abs(key.hashCode()) % numberOfNodes;
        return nodes[nodeIndex];
    }

    public V get(K key) {
        return getNodeForKey(key).get(key);
    }

    public void put(K key, V value) {
        getNodeForKey(key).put(key, value);
    }

    public static void main(String[] args) {
        // Problem 12: Design distributed cache system.
        DistributedCache<String, String> distributedCache = new DistributedCache<>(3); // 3 nodes

        distributedCache.put("user:123", "User data for 123");
        distributedCache.put("product:456", "Product data for 456");
        distributedCache.put("session:789", "Session data for 789");

        System.out.println("\nFetching 'user:123': " + distributedCache.get("user:123"));
    }
}

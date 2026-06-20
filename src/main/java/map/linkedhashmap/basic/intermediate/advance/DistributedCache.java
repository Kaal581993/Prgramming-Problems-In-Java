package map.linkedhashmap.basic.intermediate.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// A cache node that uses LinkedHashMap to implement an LRU eviction policy
class CacheNode<K, V> extends java.util.LinkedHashMap<K, V> {
    private final String nodeId;
    private final int capacity;

    public CacheNode(String nodeId, int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true for LRU
        this.nodeId = nodeId;
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        boolean shouldEvict = size() > capacity;
        if (shouldEvict) {
            System.out.println("[" + nodeId + "] Cache full. Evicting: " + eldest.getKey());
        }
        return shouldEvict;
    }
}

public class DistributedCache<K, V> {
    private final List<CacheNode<K, V>> nodes;
    private final int numberOfNodes;

    public DistributedCache(int numberOfNodes, int nodeCapacity) {
        this.numberOfNodes = numberOfNodes;
        this.nodes = new ArrayList<>(numberOfNodes);
        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(new CacheNode<>("Node-" + i, nodeCapacity));
        }
    }

    private CacheNode<K, V> getNodeForKey(K key) {
        return nodes.get(Math.abs(key.hashCode()) % numberOfNodes);
    }

    public void put(K key, V value) {
        getNodeForKey(key).put(key, value);
    }

    public V get(K key) {
        return getNodeForKey(key).get(key);
    }

    public static void main(String[] args) {
        // Problem 12: Design distributed cache system using LinkedHashMap for LRU nodes.
        DistributedCache<String, String> distributedCache = new DistributedCache<>(2, 2); // 2 nodes, 2 capacity each

        distributedCache.put("A", "Data A");
        distributedCache.put("B", "Data B");
        System.out.println("Node 0 state: " + distributedCache.nodes.get(0));
        
        distributedCache.put("C", "Data C"); // Should evict A from Node 0
        System.out.println("Node 0 state: " + distributedCache.nodes.get(0));
    }
}

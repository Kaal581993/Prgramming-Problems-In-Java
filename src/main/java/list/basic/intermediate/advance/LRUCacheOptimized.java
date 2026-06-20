package list.basic.intermediate.advance;


import java.util.HashMap;
import java.util.Map;

public class LRUCacheOptimized<K, V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node<K, V>> cache;

    // Dummy head and tail nodes to avoid null checks during insertion/deletion
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUCacheOptimized(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        // Move the accessed node to the head (most recently used)
        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = cache.get(key);

        if (node != null) {
            // Update value and move to head
            node.value = value;
            moveToHead(node);
        } else {
            // If cache is full, evict the least recently used (tail.prev)
            if (cache.size() >= capacity) {
                Node<K, V> lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }

            // Insert new node
            Node<K, V> newNode = new Node<>(key, value);
            addNode(newNode);
            cache.put(key, newNode);
        }
    }

    // Helper: Unlink a node from its current position in O(1)
    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Add a node right after the dummy head in O(1)
    private void addNode(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper: Move an existing node to the head of the list in O(1)
    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addNode(node);
    }
}
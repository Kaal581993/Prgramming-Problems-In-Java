package iterator.intermediateIterator.advanced;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Problem 15
 *
 * Design iterable cache system.
 *
 * This class implements a generic, iterable, fixed-size LRU (Least Recently Used) Cache.
 * It uses a HashMap for O(1) lookups and a Doubly Linked List to maintain access order.
 * The cache is iterable from Most Recently Used (MRU) to Least Recently Used (LRU).
 * The iterator is fail-fast.
 */
public class IterableCacheSystem<K, V> implements Iterable<Map.Entry<K, V>> {

    /**
     * Inner class for the nodes of the doubly linked list.
     * It holds the key-value pair and pointers to the previous and next nodes.
     */
    private static class Node<K, V> implements Map.Entry<K, V> {
        final K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    private final int capacity;
    private final Map<K, Node<K, V>> cacheMap;
    private final Node<K, V> head; // MRU sentinel
    private final Node<K, V> tail; // LRU sentinel
    private int modCount = 0;

    public IterableCacheSystem(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        // Initialize sentinel nodes for the doubly linked list.
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Retrieves an item from the cache. If found, it's marked as most recently used.
     * @return The value associated with the key, or null if not found.
     */
    public V get(K key) {
        Node<K, V> node = cacheMap.get(key);
        if (node == null) {
            return null; // Not in cache
        }
        // Move the accessed node to the front (MRU).
        moveToHead(node);
        return node.getValue();
    }

    /**
     * Adds or updates an item in the cache. The new/updated item becomes the most recently used.
     * If the cache is full, the least recently used item is evicted.
     */
    public void put(K key, V value) {
        Node<K, V> node = cacheMap.get(key);

        if (node != null) {
            // Key already exists, update the value and move to front.
            node.setValue(value);
            moveToHead(node);
        } else {
            // New key, create a new node.
            Node<K, V> newNode = new Node<>(key, value);
            cacheMap.put(key, newNode);
            addFirst(newNode);

            if (cacheMap.size() > capacity) {
                // Evict the least recently used item.
                Node<K, V> lruNode = removeLast();
                if (lruNode != null) {
                    cacheMap.remove(lruNode.getKey());
                }
            }
        }
        modCount++;
    }

    public int size() {
        return cacheMap.size();
    }

    // --- Doubly Linked List Helper Methods ---

    private void addFirst(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addFirst(node);
    }

    private Node<K, V> removeLast() {
        if (tail.prev == head) {
            return null; // List is empty
        }
        Node<K, V> lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    /**
     * Returns a fail-fast iterator that traverses from Most Recently Used to Least Recently Used.
     */
    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private Node<K, V> currentNode = head.next;

            @Override
            public boolean hasNext() {
                checkForComodification();
                return currentNode != tail;
            }

            @Override
            public Map.Entry<K, V> next() {
                checkForComodification();
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in cache.");
                }
                Node<K, V> result = currentNode;
                currentNode = currentNode.next;
                return result;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove is not supported by this iterator.");
            }

            private void checkForComodification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cache (MRU -> LRU): [");
        for (Iterator<Map.Entry<K, V>> it = iterator(); it.hasNext(); ) {
            Map.Entry<K, V> entry = it.next();
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Basic LRU Cache Demonstration ---");
        IterableCacheSystem<String, Integer> cache = new IterableCacheSystem<>(3);
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);
        System.out.println("Initial cache: " + cache);

        System.out.println("\nAccessing 'A'...");
        cache.get("A");
        System.out.println("Cache after get('A'): " + cache);

        System.out.println("\nAdding 'D', which should evict 'B' (the LRU item)...");
        cache.put("D", 4);
        System.out.println("Cache after put('D'): " + cache);

        System.out.println("\n--- Iterable and Fail-Fast Demonstration ---");
        System.out.println("Iterating over the cache using a for-each loop:");
        for (Map.Entry<String, Integer> entry : cache) {
            System.out.println("  Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("\nAttempting to modify the cache while iterating...");
        try {
            for (Map.Entry<String, Integer> entry : cache) {
                System.out.println("  Iterating over: " + entry.getKey());
                if (entry.getKey().equals("A")) {
                    System.out.println("  >> Modifying cache by putting 'E'...");
                    cache.put("E", 5); // This will cause the exception on the next iteration step.
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("  >> Successfully caught expected exception: " + e);
        }
        System.out.println("Final cache state: " + cache);
    }
}
package map.linkedhashmap.basic.intermediate.advance;

class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next; // For the bucket's linked list (collision handling)
    Entry<K, V> after, before; // For the doubly linked list (insertion order)

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomLinkedHashMap<K, V> {
    // A simplified implementation focusing on the linked list for insertion order.
    private Entry<K, V>[] buckets;
    private Entry<K, V> head, tail; // Head and tail for the insertion-order list
    private static final int CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public CustomLinkedHashMap() {
        buckets = new Entry[CAPACITY];
    }

    private int getBucketIndex(K key) { return Math.abs(key.hashCode()) % CAPACITY; }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        // Simplified: assumes no collisions for clarity on the linking part
        buckets[index] = newEntry;

        // Link the new entry into the doubly linked list
        if (head == null) {
            head = tail = newEntry;
        } else {
            tail.after = newEntry;
            newEntry.before = tail;
            tail = newEntry;
        }
    }

    public void displayInsertionOrder() {
        System.out.println("--- Displaying in Insertion Order ---");
        Entry<K, V> current = head;
        while (current != null) {
            System.out.println("Key: " + current.key + ", Value: " + current.value);
            current = current.after;
        }
    }

    public static void main(String[] args) {
        // Problem 11: Implement custom LinkedHashMap.
        CustomLinkedHashMap<String, Integer> map = new CustomLinkedHashMap<>();
        map.put("A", 1);
        map.put("C", 3);
        map.put("B", 2);

        map.displayInsertionOrder();
    }
}

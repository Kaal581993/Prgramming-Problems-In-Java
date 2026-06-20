package map.concurrenthashmap.advance;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

class Entry<K, V> {
    K key; V value;
    public Entry(K key, V value) { this.key = key; this.value = value; }
}

public class CustomConcurrentHashMap<K, V> {
    private static final int SEGMENT_COUNT = 16;
    private final Segment<K, V>[] segments;

    @SuppressWarnings("unchecked")
    public CustomConcurrentHashMap() {
        segments = new Segment[SEGMENT_COUNT];
        for (int i = 0; i < SEGMENT_COUNT; i++) {
            segments[i] = new Segment<>();
        }
    }

    private Segment<K, V> getSegment(K key) {
        return segments[Math.abs(key.hashCode()) % SEGMENT_COUNT];
    }

    public void put(K key, V value) {
        getSegment(key).put(key, value);
    }

    public V get(K key) {
        return getSegment(key).get(key);
    }

    // Each Segment is a lockable region of the map
    private static class Segment<K, V> {
        private final ReentrantLock lock = new ReentrantLock();
        private final LinkedList<Entry<K, V>>[] buckets; // Simplified with LinkedList
        private static final int BUCKET_COUNT = 16;

        @SuppressWarnings("unchecked")
        public Segment() {
            buckets = new LinkedList[BUCKET_COUNT];
            for(int i=0; i<BUCKET_COUNT; i++) buckets[i] = new LinkedList<>();
        }

        private int getBucketIndex(K key) { return Math.abs(key.hashCode()) % BUCKET_COUNT; }

        public void put(K key, V value) {
            lock.lock();
            try {
                // Simplified: assumes no key collision for clarity
                buckets[getBucketIndex(key)].add(new Entry<>(key, value));
            } finally {
                lock.unlock();
            }
        }

        public V get(K key) {
            // Get is typically non-locking in a real implementation, but simplified here
            lock.lock();
            try {
                for(Entry<K,V> entry : buckets[getBucketIndex(key)]){
                    if(entry.key.equals(key)) return entry.value;
                }
                return null;
            } finally {
                lock.unlock();
            }
        }
    }
    
    public static void main(String[] args) {
        // Problem 11: Implement custom ConcurrentHashMap (with lock striping).
        CustomConcurrentHashMap<String, Integer> map = new CustomConcurrentHashMap<>();
        map.put("A", 1);
        System.out.println("Value for A: " + map.get("A"));
    }
}

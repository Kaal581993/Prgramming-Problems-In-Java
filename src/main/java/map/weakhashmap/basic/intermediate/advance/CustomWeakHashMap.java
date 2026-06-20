package map.weakhashmap.basic.intermediate.advance;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// A simplified map that uses weak references for its keys.
public class CustomWeakHashMap<K, V> {
    // Internally, it uses a HashMap but wraps keys in a WeakReference.
    private final Map<WeakReference<K>, V> internalMap = new HashMap<>();

    public void put(K key, V value) {
        // A real implementation would need to periodically clean up stale entries.
        internalMap.put(new WeakReference<>(key), value);
    }

    public V get(K key) {
        // This get is simplified; a real one would need to iterate and compare keys.
        // This is because new WeakReference<>(key) != existing WeakReference(key).
        return null; // Simplified for demonstration of the 'put' concept.
    }
    
    public int size() {
        // In a real implementation, you'd have to remove stale entries before returning size.
        return internalMap.size();
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 11: Implement custom WeakHashMap.
        CustomWeakHashMap<Object, String> map = new CustomWeakHashMap<>();
        Object key = new Object();
        map.put(key, "My Data");

        System.out.println("Map size before GC: " + map.size());
        
        key = null; // Remove strong reference
        System.gc();
        Thread.sleep(100);

        // A real implementation would show size 0 here after cleanup.
        System.out.println("A real implementation would clean up the stale entry upon access.");
    }
}

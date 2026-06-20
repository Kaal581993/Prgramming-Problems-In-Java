package map.weakhashmap.basic.intermediate.advance;

import java.util.Map;
import java.util.WeakHashMap;

class DataObject {
    String data;
    public DataObject(String data) { this.data = data; }
    @Override public String toString() { return "DataObject{data='" + data + "'}"; }
}

// Represents a client-side view of a distributed cache
class ClientCache {
    // WeakHashMap holds a local, temporary copy of data.
    // If the application using the client loses all references to a DataObject,
    // this cache will automatically drop its entry.
    private final Map<String, WeakReference<DataObject>> localCache = new WeakHashMap<>();

    public DataObject get(String key) {
        // In a real system, if not in localCache, fetch from the distributed cache.
        WeakReference<DataObject> ref = localCache.get(key);
        return (ref != null) ? ref.get() : null;
    }

    public void put(String key, DataObject value) {
        localCache.put(key, new WeakReference<>(value));
    }
}

public class DistributedCache {
    public static void main(String[] args) throws InterruptedException {
        // Problem 12: Use WeakHashMap for a client-side cache layer.
        ClientCache client = new ClientCache();
        DataObject data = new DataObject("Some important data");
        
        client.put("data:123", data);
        System.out.println("Client has data: " + client.get("data:123"));

        data = null; // App loses its strong reference
        System.gc();
        Thread.sleep(100);

        // The data is now likely gone from the client-side cache.
        System.out.println("After GC, client has data: " + client.get("data:123"));
    }
}

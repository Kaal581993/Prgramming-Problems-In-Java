package map.weakhashmap.basic.intermediate.advance;

import java.util.Map;
import java.util.WeakHashMap;

public class InMemoryDatabase {
    // Using WeakHashMap for a database is a terrible idea.
    // Data would be unpredictably deleted by the garbage collector.
    // This is for demonstration of what NOT to do.
    private final Map<String, Object> table = new WeakHashMap<>();

    public void insert(String key, Object row) {
        table.put(key, row);
    }

    public static void main(String[] args) {
        // Problem 14: Build in-memory database using WeakHashMap (demonstrating unsuitability).
        InMemoryDatabase db = new InMemoryDatabase();
        
        String key = new String("user:1");
        Map<String, String> row = Map.of("name", "Alice");
        db.insert(key, row);

        System.out.println("Database size: " + db.table.size());
        
        key = null; // Lose reference to the key
        System.gc();

        // The data is now likely gone, which is disastrous for a database.
        System.out.println("Database size after GC: " + db.table.size());
    }
}

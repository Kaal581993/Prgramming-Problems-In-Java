package map.concurrenthashmap.advance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// A thread-safe table using ConcurrentHashMap
class DbTable {
    private final Map<String, Map<String, Object>> rows = new ConcurrentHashMap<>();

    public void insert(String primaryKey, Map<String, Object> row) {
        rows.put(primaryKey, new ConcurrentHashMap<>(row));
    }

    public Map<String, Object> find(String primaryKey) {
        return rows.get(primaryKey);
    }
}

public class InMemoryDatabase {
    private final Map<String, DbTable> tables = new ConcurrentHashMap<>();

    public DbTable createTable(String tableName) {
        return tables.computeIfAbsent(tableName, k -> new DbTable());
    }

    public static void main(String[] args) {
        // Problem 14: Build a thread-safe in-memory database using ConcurrentHashMap.
        InMemoryDatabase db = new InMemoryDatabase();
        DbTable usersTable = db.createTable("users");

        // Simulate concurrent inserts
        new Thread(() -> usersTable.insert("user:1", Map.of("name", "Alice"))).start();
        new Thread(() -> usersTable.insert("user:2", Map.of("name", "Bob"))).start();
        
        try { Thread.sleep(100); } catch (InterruptedException e) {}

        System.out.println("Found user:1 -> " + usersTable.find("user:1"));
    }
}

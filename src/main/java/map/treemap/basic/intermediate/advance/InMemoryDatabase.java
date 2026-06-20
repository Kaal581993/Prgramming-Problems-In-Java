package map.treemap.basic.intermediate.advance;

import java.util.Map;
import java.util.TreeMap;

// A table where rows are sorted by primary key
class DbTable {
    private final Map<String, Map<String, Object>> rows = new TreeMap<>();

    public void insert(String primaryKey, Map<String, Object> row) {
        rows.put(primaryKey, new TreeMap<>(row)); // Also sort columns
    }

    public Map<String, Object> find(String primaryKey) {
        return rows.get(primaryKey);
    }
    
    public void displayAll() {
        System.out.println("--- Table Data (Sorted by Primary Key) ---");
        rows.forEach((key, data) -> System.out.println(key + ": " + data));
    }
}

public class InMemoryDatabase {
    // Tables are sorted by name
    private final Map<String, DbTable> tables = new TreeMap<>();

    public DbTable createTable(String tableName) {
        return tables.computeIfAbsent(tableName, k -> new DbTable());
    }

    public static void main(String[] args) {
        // Problem 14: Build in-memory database using TreeMap for sorted data storage.
        InMemoryDatabase db = new InMemoryDatabase();
        DbTable usersTable = db.createTable("users");

        usersTable.insert("user:3", Map.of("name", "Charlie"));
        usersTable.insert("user:1", Map.of("name", "Alice"));
        usersTable.insert("user:2", Map.of("name", "Bob"));

        usersTable.displayAll();
    }
}

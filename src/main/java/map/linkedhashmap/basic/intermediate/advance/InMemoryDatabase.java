package map.linkedhashmap.basic.intermediate.advance;

import java.util.LinkedHashMap;
import java.util.Map;

// A table where rows are stored in insertion order
class DbTable {
    private final Map<String, Map<String, Object>> rows = new LinkedHashMap<>();

    public void insert(String primaryKey, Map<String, Object> row) {
        rows.put(primaryKey, new LinkedHashMap<>(row)); // Preserve column insertion order too
    }

    public void displayAll() {
        System.out.println("--- Table Data (in insertion order) ---");
        rows.forEach((key, data) -> System.out.println(key + ": " + data));
    }
}

public class InMemoryDatabase {
    private final Map<String, DbTable> tables = new LinkedHashMap<>();

    public DbTable createTable(String tableName) {
        return tables.computeIfAbsent(tableName, k -> new DbTable());
    }

    public static void main(String[] args) {
        // Problem 14: Build in-memory database using LinkedHashMap for insertion-ordered rows.
        InMemoryDatabase db = new InMemoryDatabase();
        DbTable usersTable = db.createTable("users");

        usersTable.insert("user:3", Map.of("name", "Charlie"));
        usersTable.insert("user:1", Map.of("name", "Alice"));
        usersTable.insert("user:2", Map.of("name", "Bob"));

        usersTable.displayAll();
    }
}

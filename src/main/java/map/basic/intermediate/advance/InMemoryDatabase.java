package map.basic.intermediate.advance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Represents a single table in the database
class DbTable {
    // A table is a map of primary keys to rows. A row is a map of column names to values.
    private final Map<String, Map<String, Object>> rows = new ConcurrentHashMap<>();

    public void insert(String primaryKey, Map<String, Object> row) {
        rows.put(primaryKey, new ConcurrentHashMap<>(row));
    }

    public Map<String, Object> find(String primaryKey) {
        return rows.get(primaryKey);
    }

    public void update(String primaryKey, String column, Object value) {
        Map<String, Object> row = rows.get(primaryKey);
        if (row != null) {
            row.put(column, value);
        }
    }

    public void delete(String primaryKey) {
        rows.remove(primaryKey);
    }
}

public class InMemoryDatabase {
    // The database is a map of table names to table objects
    private final Map<String, DbTable> tables = new ConcurrentHashMap<>();

    public DbTable createTable(String tableName) {
        return tables.computeIfAbsent(tableName, k -> new DbTable());
    }

    public DbTable getTable(String tableName) {
        return tables.get(tableName);
    }

    public static void main(String[] args) {
        // Problem 14: Build in-memory database.
        InMemoryDatabase db = new InMemoryDatabase();
        DbTable usersTable = db.createTable("users");

        // Insert a new user
        Map<String, Object> user1 = new HashMap<>();
        user1.put("name", "Alice");
        user1.put("age", 30);
        usersTable.insert("user:1", user1);

        // Find and display the user
        System.out.println("Found user:1 -> " + usersTable.find("user:1"));

        // Update the user's age
        usersTable.update("user:1", "age", 31);
        System.out.println("Updated user:1 -> " + usersTable.find("user:1"));
    }
}

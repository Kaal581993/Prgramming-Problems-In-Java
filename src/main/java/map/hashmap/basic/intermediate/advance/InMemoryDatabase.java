package map.hashmap.basic.intermediate.advance;

import java.util.HashMap;
import java.util.Map;

// Represents a single table
class DbTable {
    // A table is a map of primary keys to rows (which are also maps)
    private final Map<String, Map<String, Object>> rows = new HashMap<>();

    public void insert(String primaryKey, Map<String, Object> row) {
        rows.put(primaryKey, new HashMap<>(row));
    }

    public Map<String, Object> find(String primaryKey) {
        return rows.get(primaryKey);
    }

    public void update(String primaryKey, String column, Object value) {
        rows.computeIfPresent(primaryKey, (k, row) -> {
            row.put(column, value);
            return row;
        });
    }

    public void delete(String primaryKey) {
        rows.remove(primaryKey);
    }
}

public class InMemoryDatabase {
    // The database is a map of table names to table objects
    private final Map<String, DbTable> tables = new HashMap<>();

    public DbTable createTable(String tableName) {
        return tables.computeIfAbsent(tableName, k -> new DbTable());
    }

    public DbTable getTable(String tableName) {
        return tables.get(tableName);
    }

    public static void main(String[] args) {
        // Problem 14: Build in-memory database using HashMap.
        InMemoryDatabase db = new InMemoryDatabase();
        DbTable usersTable = db.createTable("users");

        Map<String, Object> user1 = new HashMap<>();
        user1.put("name", "Alice");
        user1.put("email", "alice@example.com");
        usersTable.insert("user:1", user1);

        System.out.println("Found user:1 -> " + usersTable.find("user:1"));
        usersTable.update("user:1", "email", "new.alice@example.com");
        System.out.println("Updated user:1 -> " + usersTable.find("user:1"));
    }
}

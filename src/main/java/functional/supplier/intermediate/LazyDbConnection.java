package functional.supplier.intermediate;

import java.util.function.Supplier;

class DatabaseConnection {
    public DatabaseConnection() {
        // This constructor simulates an expensive operation.
        System.out.println("Connecting to the database... (This is slow)");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("Database connection established.");
    }
    public void query(String sql) { System.out.println("Executing query: " + sql); }
}

public class LazyDbConnection {
    private static DatabaseConnection connection = null;

    // The supplier will create the connection only when needed.
    public static Supplier<DatabaseConnection> dbConnectionSupplier = () -> {
        if (connection == null) {
            connection = new DatabaseConnection();
        }
        return connection;
    };

    public static void main(String[] args) {
        // Problem 6: Implement lazy DB connection.
        System.out.println("Application started. No DB connection yet.");

        // The connection is only created when we call .get() for the first time.
        dbConnectionSupplier.get().query("SELECT * FROM users");
        
        // This second call will not create a new connection.
        dbConnectionSupplier.get().query("SELECT * FROM products");
    }
}

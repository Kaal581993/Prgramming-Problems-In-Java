package exception_handling.intermediate.try_with_resources;

public class DatabaseImplementation {

    public static void main(String[] args) {

        System.out.println("--- Starting database operations ---");
        // The resource is declared inside the try parentheses
        try (MockDatabaseConnection conn = new MockDatabaseConnection()) {

            conn.executeQuery("SELECT * FROM users;");
            conn.executeQuery("UPDATE profiles SET status = 'active';");

            // At this point, the try block ends, and Java automatically triggers conn.close()
        } catch (Exception e) {
            System.err.println("Caught an exception: " + e.getMessage());
        }
        System.out.println("--- Program finished ---");

    }
}
 class MockDatabaseConnection implements AutoCloseable{
        private boolean isClosed = false;
        // 1. Setup the mock connection upon instantiation
         public  MockDatabaseConnection() {
            System.out.println("[Database] Connected successfully to mock database.");
        }
        // 2. A mock database operation
        public void executeQuery(String sql) {
            if (isClosed) {
                throw new IllegalStateException("[Error] Cannot run query. The connection is already closed!");
            }
            System.out.println("[Database] Executing query: " + sql);
        }
        // 3. Implementing the AutoCloseable contract
        @Override
        public void close() {
            this.isClosed = true;
            System.out.println("[Database] Connection closed and network socket released.");

        }
}
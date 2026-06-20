package exception_handling.intermediate.try_with_resources;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderClassTryWithResources {
    public static void main(String[] args) {
        // Declare resources inside try parentheses
        try (FileReader reader = new FileReader("example.txt")) {
            int data = reader.read();
            // Process data...
        } catch (IOException e) {
            System.err.println("Handling error: " + e.getMessage());
        } // The reader is closed automatically right here!
    }
}

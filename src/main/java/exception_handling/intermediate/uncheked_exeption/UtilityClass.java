//package exception_handling.intermediate.uncheked_exeption;
//
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class UtilityClass {
//
//    public static void main(String[] args) {
//
//        FileReaderClass fileReader = new FileReaderClass();
//        FileWriterClass fileWrite = new FileWriterClass();
//        try {
//            fileReader.readFile("non_existent_file.txt");
//
//            fileWrite.writeFile("existent_file.txt","This is file writer magic");
//        } catch (IOException e) {
//            System.out.println("Caught Expected Checked Exception: " + e.toString());
//        }
//        System.out.println();
//    }
//}
//
//class FileReaderClass{
//    public static void readFile(String fileName) throws IOException {
//        // FileReader constructor throws FileNotFoundException (subclass of IOException)
//        // read() method throws IOException
//        FileReader reader = new FileReader(fileName);
//            reader.read();
//
//        reader.close();
//    }
//}
//
//class FileWriterClass{
//        public static void writeFile(String fileName, String data)
//                throws IOException {
//            // FileReader constructor throws FileNotFoundException (subclass of IOException)
//            // read() method throws IOException
//            FileWriter writer = new FileWriter(fileName);
//            writer.write(data);
//            writer.close();
//        }
//
//}


package exception_handling.intermediate.uncheked_exeption;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A utility class for file operations.
 *
 * Design characteristics:
 * 1. The class is declared final so it cannot be inherited.
 * 2. It has a private constructor to prevent instantiation
 * (objects cannot be created).
 * 3. All methods are static and propagate exceptions
 * (via 'throws') to the caller.
 * 4. Uses try-with-resources to prevent resource leaks while
 * letting exceptions propagate.
 */
public final class UtilityClass {

    public static void main(String[] args) {
        // Correct usage: Call static methods directly using the class name (no 'new')

        System.out.println("--- Test 1: Reading a non-existent file ---");
        try {
            // This will throw a FileNotFoundException
            // (which is a subclass of IOException)
            // Because FileUtility propagates exceptions,
            // this method call will raise the exception here.
            UtilityClass.readFile("non_existent_file.txt");
        } catch (IOException e) {
            System.out.println("Caught Expected Checked Exception: " + e.toString());
        }
        System.out.println("\n--- Test 2: Writing and then reading a file ---");
        try {
            // Write to a file
            UtilityClass.writeFile("existent_file.txt", "This is file writer magic!");
            System.out.println("Write operation completed successfully.");
            // Read the file we just wrote
            System.out.print("Reading file contents: ");
            UtilityClass.readFile("existent_file.txt");
        } catch (IOException e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
        }
    }


    // Private constructor prevents instantiation
    private UtilityClass() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }

    /**
     * Reads and prints the contents of a file.
     * Any IOException encountered is propagated directly to the caller.
     */
    public static void readFile(String fileName) throws IOException {
        // Try-with-resources automatically closes FileReader
        // even if an exception occurs

        try (FileReader reader = new FileReader(fileName)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();
        }
        // Notice: No catch block here. Exceptions propagate automatically.
    }

    /**
     * Writes data to a file.
     * Any IOException encountered is propagated directly to the caller.
     */
    public static void writeFile(
            String fileName,
            String data) throws IOException {
        // Try-with-resources automatically closes FileWriter even
        // if an exception occurs
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
        }
        // Notice: No catch block here. Exceptions propagate automatically.
    }
}
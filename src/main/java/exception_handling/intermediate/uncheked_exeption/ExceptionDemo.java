package exception_handling.intermediate.uncheked_exeption;


import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println("=== Java Exception Handling Demonstration ===\n");

        // 1. Unchecked Exception Demo (ArithmeticException)
        System.out.println("--- 1. Demonstrating Unchecked Exception (ArithmeticException) ---");
        System.out.println("Unchecked exceptions (RuntimeException and its subclasses) are NOT checked at compile-time.");
        System.out.println("You are not forced by the compiler to handle or declare them.");

        try {
            int result = divide(10, 0);
            System.out.println("Division Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught Expected Unchecked Exception: " + e.toString());
        }
        System.out.println();

        // 2. Checked Exception Demo (IOException)
        System.out.println("--- 2. Demonstrating Checked Exception (IOException) ---");
        System.out.println("Checked exceptions are checked at compile-time.");
        System.out.println("The compiler forces us to either handle them (try-catch) or declare them (throws).");

        try {
            readFile("non_existent_file.txt");
        } catch (IOException e) {
            System.out.println("Caught Expected Checked Exception: " + e.toString());
        }
        System.out.println();

        System.out.println("=== Summary of Key Differences ===");
        System.out.println("1. Checked Exception (e.g., IOException):");
        System.out.println("   - Inherits directly from Exception (but not RuntimeException).");
        System.out.println("   - Compiler enforces handling (try-catch) or propagation (throws).");
        System.out.println("   - Represents conditions outside the control of the program (e.g., missing file, network failure).");
        System.out.println("2. Unchecked Exception (e.g., ArithmeticException):");
        System.out.println("   - Inherits from RuntimeException.");
        System.out.println("   - Compiler does NOT enforce handling or declaration.");
        System.out.println("   - Represents programming errors / logic flaws (e.g., division by zero, null pointer).");
    }

    /**
     * Demonstrates an unchecked exception (ArithmeticException).
     * No 'throws ArithmeticException' clause is required, though it can be added for documentation.
     */
    public static int divide(int numerator, int denominator) {
        // This will throw java.lang.ArithmeticException if denominator is 0
        return numerator / denominator;
    }

    /**
     * Demonstrates a checked exception (IOException).
     * Because IOException is checked, the compiler requires this method to either
     * catch it internally or declare it in the method signature using 'throws'.
     */
    public static void readFile(String fileName) throws IOException {
        // FileReader constructor throws FileNotFoundException (subclass of IOException)
        // read() method throws IOException
        FileReader reader = new FileReader(fileName);
        reader.read();
        reader.close();
    }
}
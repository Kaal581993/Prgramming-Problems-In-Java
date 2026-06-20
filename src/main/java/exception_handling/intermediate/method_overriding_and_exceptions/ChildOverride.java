package exception_handling.intermediate.method_overriding_and_exceptions;


import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ChildOverride {

    public static void main(String[] args) throws IOException {
        System.out.println("=== 1. Scanner Demo using Simulated Input ===");

        byte[] inputData1 = "5\n".getBytes();
        Child tf = new Child();
        tf.IOExceptionDemo(inputData1);

    }
}

 class Parent{

    public  void IOExceptionDemo(byte[] inputData) throws IOException {
        try (FileReader reader = new FileReader("example.txt")) {
            int data = reader.read();
            // Process data...
        } catch (IOException e) {
            System.err.println("Handling error: " + e.getMessage());
        } // The reader is closed automatically right here!
    }


 }

class Child extends Parent{

    @Override
    public void IOExceptionDemo(byte[] inputData) throws IOException{
        System.out.println("\n--- Try-Finally Scanner Demo ---");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new ByteArrayInputStream(inputData));
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num >= 0 && num % 2 != 0) {
                    System.out.println("The number is odd");
                } else {
                    System.out.println("The number is even");
                }
            } else {
                System.err.println("The Entered Value is not Integer");
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Traditional try-finally requires manual null checks and manual close() invocation
            System.out.println("Finally block: Closing scanner manually...");
            if (scanner != null) {
                scanner.close();
            }
        }
    }

}

//package exception_handling.intermediate.try_with_resources;
//
//import javax.naming.directory.InvalidAttributesException;
//import java.util.Scanner;
//
//public class compareTryFinallyTryWithResources {
//
//    public static void main(String[] args) {
//
//        TryFinally tf = new TryFinally();
//        tf.tryFinallyDemo();
//
//        TryWithResources twr = new TryWithResources();
//        twr.tryResourcesDemo();
//    }
//
//
//
//}
//
//class TryFinally{
//    public void tryFinallyDemo(){
//
//        Scanner scanner = new Scanner(System.in);
//
//        try{
//
//            int num = scanner.nextInt();
//            if(num >=0 && num%2!=0){
//                System.out.println("The number is odd");
//            }else{
//                System.out.println("The number is even");
//            }
//        }catch (Exception e){
//            System.err.println("The Entered Value is not Integer");
//        }finally {
//            int num = scanner.nextInt();
//
//
//        }
//    }
//}
//
//class TryWithResources{
//    public void tryResourcesDemo(){
//
//        Scanner scanner = new Scanner(System.in);
//
//        try{
//
//            int num = scanner.nextInt();
//            if(num >=0 && num%2!=0){
//                System.out.println("The number is odd");
//            }else{
//                System.out.println("The number is even");
//            }
//        }catch (Exception e){
//            System.err.println("The Entered Value is not Integer");
//        }
//    }
//}


/**
 *
 * provided code does not solve the problem correctly. It
 * contains several critical bugs and does not correctly implement
 * the try-with-resources syntax.
 *
 * Issues in Your Original Code
 * Bug in TryFinally.tryFinallyDemo:
 *
 * Instead of closing the scanner in the finally block, you call i
 * nt num = scanner.nextInt(); which tries to read another integer.
 * To close a resource traditionally, you must call scanner.close()
 * (and wrap it in a null-check to avoid NullPointerException if initialization
 * failed).
 * Incorrect Try-With-Resources Syntax in TryWithResources.tryResourcesDemo:
 *
 * Your code declares the scanner outside the try block and does not use the
 * resource specification header.
 * Try-with-resources syntax requires declaring the resource inside parentheses
 * directly after try, like so: try (Scanner scanner = new Scanner(System.in))
 * { ... }. Because you didn't do this, the scanner is never closed.
 * Global System.in Closure Issue:
 *
 * In Java, closing a Scanner wrapped around System.in closes the global
 * standard input stream. Running both demos sequentially using standard
 * console input will cause the second demo to fail with a
 * NoSuchElementException or IllegalStateException.
 *
 * */

package exception_handling.intermediate.try_with_resources;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class CompareTryFinallyTryWithResources {

    public static void main(String[] args) {
        // We simulate user input using ByteArrayInputStream
        // so that closing the Scanner
        // does not affect global System.in, allowing both demos
        // to run successfully.

        System.out.println("=== 1. Scanner Demo using Simulated Input ===");

        byte[] inputData1 = "5\n".getBytes();
        TryFinally tf = new TryFinally();
        tf.tryFinallyDemo(inputData1);

        byte[] inputData2 = "8\n".getBytes();
        TryWithResources twr = new TryWithResources();
        twr.tryResourcesDemo(inputData2);

        System.out.println(
                "\n=== 2. Detailed Comparison using Custom AutoCloseable Resource ===");

        CustomResourceDemo.runDemo();
    }
}

class TryFinally {
    public void tryFinallyDemo(byte[] inputData) {
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

class TryWithResources {
    public void tryResourcesDemo(byte[] inputData) {
        System.out.println("\n--- Try-With-Resources Scanner Demo ---");
        // Resources declared in the try-with-resources statement are automatically closed
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(inputData))) {
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
        }
        // No finally block is needed to close the resource! It is closed automatically.
    }
}

// A custom resource to demonstrate automatic closure
class CustomResource implements AutoCloseable {
    private final String name;

    public CustomResource(String name) {
        this.name = name;
        System.out.println("[Resource] " + name + " initialized/opened.");
    }

    public void doWork(boolean throwException) throws Exception {
        System.out.println("[Resource] " + name + " performing work.");
        if (throwException) {
            throw new Exception("Error during doWork() in " + name);
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("[Resource] " + name + " closed automatically.");
    }
}

class CustomResourceDemo {
    public static void runDemo() {
        System.out.println("\n--- Custom AutoCloseable Resource Demo ---");

        try (CustomResource resource = new CustomResource("MyDatabaseConnection")) {
            resource.doWork(false);
        } catch (Exception e) {
            System.err.println("Caught: " + e.getMessage());
        }
    }
}
//package exception_handling.intermediate.advance.interview_problems;
//
//import java.io.IOException;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class SafeCalculator extends IOException {
//    public static void main(String[] args) {
//
//        try{
//            Scanner scan = new Scanner(System.in);
//
//            int a = scan.nextInt();
//            int b = scan.nextInt();
//
//            System.out.println(a+"+"+b+"="+add(a,b));
//            System.out.println(a+"-"+b+"="+sub(a,b));
//            System.out.println(a+"x"+b+"="+multiply(a,b));
//            System.out.println(a+"/"+b+"="+divide(a,b));
//
//        }catch (ArithmeticException ae){
//            System.err.println("Invalid Value "+ ae.getMessage());
//        } catch (InputMismatchException ipe) {
//            System.err.println("Invalid Input, you need ad Integer values only for this operation "+ ipe.getMessage());
//        }
//    }
//
//    public static int add(int a, int b){
//        return a+b;
//    }
//
//    public static int sub(int a,int b){
//        return a-b;
//    }
//
//    public static int multiply(int a,int b){
//        return a*b;
//    }
//
//    public static int divide(int a, int b){
//        return a/b;
//    }
//}

/**
 *
 * the provided code does not solve the problem in a robust, safe, or
 * standard manner. It contains several critical bugs, design flaws, and
 * semantic issues that prevent it from being a truly "Safe Calculator".
 *
 * Issues in the Original Code
 * Unnecessary Inheritance: public class SafeCalculator extends IOException
 *
 * SafeCalculator is the main driver class of the application. Having it
 * extend IOException (a checked exception) makes no architectural or logical
 * sense. This is a significant design flaw.
 *
 * Resource Leak:
 *
 * The Scanner scan is instantiated but never closed. This causes resource
 * leaks. It should be managed using a try-with-resources statement or closed in a finally block.
 * User-Unfriendly Error Message (null Output):
 *
 * The catch block handles InputMismatchException by calling ipe.getMessage().
 * However, InputMismatchException has a null message when triggered by
 * non-numeric inputs (like "abc"). This results in printing: Invalid Input,
 * you need ad Integer values only for this operation null
 * There is also a typo: "need ad Integer" instead of "need an Integer".
 * Partial Execution on Mathematical Errors:
 *
 * If the user enters 10 and 0, the addition, subtraction, and multiplication
 * print their results first. Then, the division throws ArithmeticException
 * and halts execution midway, leaving a partially completed output on the screen:
 *
 *
 * 10+0=10
 * 10-0=10
 * 10x0=0
 * Invalid Value / by zero
 * Silent Overflow/Underflow:
 *
 * Standard arithmetic operators (+, -, *) in Java silently overflow.
 * For example, if a user enters 2147483647 (Integer.MAX_VALUE) and 1,
 * the addition returns -2147483648 instead of raising an exception.
 * A safe calculator should detect and handle overflow.
 *
 *The Corrected & Robust Solution:
 *
 * */



package exception_handling.intermediate.advance.interview_problems;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeCalculator {
    public static void main(String[] args) {
        System.out.println("=== Safe Calculator ===");
        System.out.println("Enter two integers to perform addition, subtraction, multiplication, and division.");

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter first number (a): ");
            int a = scan.nextInt();

            System.out.print("Enter second number (b): ");
            int b = scan.nextInt();

            System.out.println("\n--- Results ---");

            // Addition with overflow handling
            try {
                System.out.println(a + " + " + b + " = " + add(a, b));
            } catch (ArithmeticException ae) {
                System.err.println("Addition failed: " + ae.getMessage());
            }

            // Subtraction with overflow handling
            try {
                System.out.println(a + " - " + b + " = " + sub(a, b));
            } catch (ArithmeticException ae) {
                System.err.println("Subtraction failed: " + ae.getMessage());
            }

            // Multiplication with overflow handling
            try {
                System.out.println(a + " x " + b + " = " + multiply(a, b));
            } catch (ArithmeticException ae) {
                System.err.println("Multiplication failed: " + ae.getMessage());
            }

            // Division with division-by-zero handling
            try {
                System.out.println(a + " / " + b + " = " + divide(a, b));
            } catch (ArithmeticException ae) {
                System.err.println("Division failed: " + ae.getMessage());
            }

        } catch (InputMismatchException ipe) {
            System.err.println("Error: Invalid input. You must enter integer values within the range of "
                    + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE + ".");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static int add(int a, int b) {
        return Math.addExact(a, b);
    }

    public static int sub(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public static int multiply(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

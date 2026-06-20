package functional.function.basic;

import java.util.function.Function;

public class CalculateStringLength {
    public static void main(String[] args) {
        // Problem 3: Calculate string length.
        // This function takes a String and returns an Integer.
        // We can use a method reference here for conciseness.
        Function<String, Integer> calculateLength = String::length;

        String text = "Hello, Function!";
        int length = calculateLength.apply(text);

        System.out.println("The length of '" + text + "' is " + length);
    }
}

package functional.function.basic;

import java.util.function.Function;

public class ConvertStringToUppercase {
    public static void main(String[] args) {
        // Problem 1: Convert string to uppercase.
        // This function takes a String as input and returns a String as output.
        Function<String, String> toUppercase = str -> str.toUpperCase();

        String original = "hello world";
        String transformed = toUppercase.apply(original);

        System.out.println("Original: " + original);
        System.out.println("Transformed: " + transformed);
    }
}

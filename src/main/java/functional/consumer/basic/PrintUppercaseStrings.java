package functional.consumer.basic;

import java.util.function.Consumer;

public class PrintUppercaseStrings {
    public static void main(String[] args) {
        // Problem 2: Print uppercase strings.
        Consumer<String> printUppercase = str -> System.out.println(str.toUpperCase());

        printUppercase.accept("hello");
        printUppercase.accept("world");
    }
}

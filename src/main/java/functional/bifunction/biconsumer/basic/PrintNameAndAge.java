package functional.bifunction.biconsumer.basic;

import java.util.function.BiConsumer;

public class PrintNameAndAge {
    public static void main(String[] args) {
        // Problem 1: Print name and age.
        BiConsumer<String, Integer> printNameAndAge = (name, age) ->
                System.out.println("Name: " + name + ", Age: " + age);

        printNameAndAge.accept("Alice", 30);
    }
}

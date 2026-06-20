package functional.function.basic;

import java.util.function.Function;

public class FindSquareOfNumbers {
    public static void main(String[] args) {
        // Problem 2: Find square of numbers.
        // This function takes an Integer and returns an Integer.
        Function<Integer, Integer> square = number -> number * number;

        int number = 5;
        int result = square.apply(number);

        System.out.println("The square of " + number + " is " + result);
    }
}

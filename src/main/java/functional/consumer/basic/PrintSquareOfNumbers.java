package functional.consumer.basic;

import java.util.function.Consumer;

public class PrintSquareOfNumbers {
    public static void main(String[] args) {
        // Problem 1: Print square of numbers.
        Consumer<Integer> printSquare = number -> System.out.println("The square of " + number + " is " + (number * number));

        printSquare.accept(5);
        printSquare.accept(10);
    }
}

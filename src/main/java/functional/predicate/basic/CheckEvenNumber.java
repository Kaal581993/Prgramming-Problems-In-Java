package functional.predicate.basic;

import java.util.function.Predicate;

public class CheckEvenNumber {
    public static void main(String[] args) {
        // Problem 1: Check if number is even.
        Predicate<Integer> isEven = number -> number % 2 == 0;

        int num1 = 10;
        int num2 = 7;

        System.out.println("Is " + num1 + " even? " + isEven.test(num1));
        System.out.println("Is " + num2 + " even? " + isEven.test(num2));
    }
}

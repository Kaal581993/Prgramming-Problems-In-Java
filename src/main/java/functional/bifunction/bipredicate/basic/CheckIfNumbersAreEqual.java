package functional.bifunction.bipredicate.basic;

import java.util.function.BiPredicate;

public class CheckIfNumbersAreEqual {
    public static void main(String[] args) {
        // Problem 1: Check if two numbers are equal.
        BiPredicate<Integer, Integer> areEqual = (num1, num2) -> num1.equals(num2);

        System.out.println("Are 5 and 5 equal? " + areEqual.test(5, 5));
        System.out.println("Are 5 and 10 equal? " + areEqual.test(5, 10));
    }
}

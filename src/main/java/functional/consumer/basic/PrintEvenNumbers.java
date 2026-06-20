package functional.consumer.basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PrintEvenNumbers {
    public static void main(String[] args) {
        // Problem 4: Print even numbers from list.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Consumer<Integer> printNumber = number -> System.out.print(number + " ");

        System.out.println("Even numbers in the list:");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(printNumber);
    }
}

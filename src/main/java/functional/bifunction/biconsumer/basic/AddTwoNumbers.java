package functional.bifunction.biconsumer.basic;

import java.util.function.BiConsumer;

public class AddTwoNumbers {
    public static void main(String[] args) {
        // Problem 2: Add two numbers using BiConsumer.
        BiConsumer<Integer, Integer> addAndPrint = (num1, num2) ->
                System.out.println("Sum: " + (num1 + num2));

        addAndPrint.accept(10, 20);
    }
}

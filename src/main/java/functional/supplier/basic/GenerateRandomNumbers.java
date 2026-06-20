package functional.supplier.basic;

import java.util.Random;
import java.util.function.Supplier;

public class GenerateRandomNumbers {
    public static void main(String[] args) {
        // Problem 1: Generate random numbers.
        Random random = new Random();
        Supplier<Integer> randomNumberSupplier = () -> random.nextInt(100); // Generates a number between 0 and 99

        System.out.println("Generated random number: " + randomNumberSupplier.get());
        System.out.println("Generated random number: " + randomNumberSupplier.get());
    }
}

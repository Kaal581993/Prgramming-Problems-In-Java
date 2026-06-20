package functional.bifunction.bipredicate.advance;

import java.util.function.BiPredicate;

public final class ReusableValidationFramework {

    private ReusableValidationFramework() {}

    // Checks if the length of a string is within a given range (inclusive).
    public static BiPredicate<String, int[]> isLengthBetween() {
        return (str, range) -> str.length() >= range[0] && str.length() <= range[1];
    }

    // Checks if a number is greater than another number.
    public static <N extends Number & Comparable<N>> BiPredicate<N, N> isGreaterThan() {
        return (n1, n2) -> n1.compareTo(n2) > 0;
    }

    public static void main(String[] args) {
        // Problem 13: Create reusable validation framework.

        // Validate password length
        BiPredicate<String, int[]> passwordValidator = isLengthBetween();
        System.out.println("Is 'password123' length between 8 and 16? " + passwordValidator.test("password123", new int[]{8, 16}));
        System.out.println("Is 'short' length between 8 and 16? " + passwordValidator.test("short", new int[]{8, 16}));

        // Validate price
        BiPredicate<Double, Double> priceValidator = isGreaterThan();
        System.out.println("\nIs 19.99 greater than 10.0? " + priceValidator.test(19.99, 10.0));
    }
}

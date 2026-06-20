package functional.bifunction.bipredicate.intermediate;

import java.util.function.BiPredicate;

public class ValidateProduct {
    public static void main(String[] args) {
        // Problem 7: Validate product name and price.
        // Rule 1: Name must not be empty.
        BiPredicate<String, Double> isNameValid = (name, price) -> name != null && !name.trim().isEmpty();
        // Rule 2: Price must be greater than zero.
        BiPredicate<String, Double> isPriceValid = (name, price) -> price > 0;

        // Combine the rules
        BiPredicate<String, Double> isProductValid = isNameValid.and(isPriceValid);

        System.out.println("Is ('Laptop', 1200.0) a valid product? " + isProductValid.test("Laptop", 1200.0));
        System.out.println("Is ('', 50.0) a valid product? " + isProductValid.test("", 50.0));
        System.out.println("Is ('Mouse', -10.0) a valid product? " + isProductValid.test("Mouse", -10.0));
    }
}

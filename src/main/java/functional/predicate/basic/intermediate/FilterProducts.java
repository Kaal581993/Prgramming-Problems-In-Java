package functional.predicate.basic.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    @Override public String toString() { return name + ": $" + price; }
}

public class FilterProducts {
    public static void main(String[] args) {
        // Problem 10: Filter products by price range (e.g., $50 to $100).
        Predicate<Product> isPriceAbove50 = product -> product.price >= 50;
        Predicate<Product> isPriceBelow100 = product -> product.price <= 100;

        Predicate<Product> isInPriceRange = isPriceAbove50.and(isPriceBelow100);

        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200),
                new Product("Mouse", 25),
                new Product("Keyboard", 75),
                new Product("Monitor", 300),
                new Product("Webcam", 90)
        );

        List<Product> affordableProducts = products.stream()
                .filter(isInPriceRange)
                .collect(Collectors.toList());

        System.out.println("Products between $50 and $100:");
        System.out.println(affordableProducts);
    }
}

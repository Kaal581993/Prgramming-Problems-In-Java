package functional.predicate.basic.intermediate.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;
    public Product(String name, String category, double price) {
        this.name = name; this.category = category; this.price = price;
    }
    @Override public String toString() { return name + " (" + category + "): $" + price; }
}

public class DynamicQueryFilter {
    private List<Predicate<Product>> filters = new ArrayList<>();

    public void addFilter(Predicate<Product> filter) {
        filters.add(filter);
    }

    public List<Product> run(List<Product> products) {
        // Combine all registered filters with 'and'
        Predicate<Product> combinedFilter = filters.stream()
                .reduce(Predicate::and)
                .orElse(p -> true); // If no filters, return all products

        return products.stream().filter(combinedFilter).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Problem 11: Build dynamic query filtering system.
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200),
                new Product("Keyboard", "Electronics", 75),
                new Product("Shirt", "Apparel", 40),
                new Product("Monitor", "Electronics", 300)
        );

        DynamicQueryFilter query = new DynamicQueryFilter();
        // We can decide which filters to add at runtime.
        query.addFilter(p -> p.category.equals("Electronics"));
        query.addFilter(p -> p.price < 100);

        List<Product> results = query.run(products);
        System.out.println("Filtered Results:");
        System.out.println(results);
    }
}

package functional.bifunction.bipredicate.advance;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

class Product {
    String category;
    double price;
    public Product(String cat, double p) { category = cat; price = p; }
    @Override public String toString() { return "Product{cat='" + category + "', price=" + price + '}'; }
}

class FilterConfig {
    String targetCategory;
    double maxPrice;
    public FilterConfig(String cat, double max) { targetCategory = cat; maxPrice = max; }
}

public class ComplexFilteringSystem {
    public static List<Product> filterProducts(List<Product> products, FilterConfig config) {
        // BiPredicate to check if a product matches the filter configuration.
        BiPredicate<Product, FilterConfig> matchesConfig = (product, conf) ->
                product.category.equals(conf.targetCategory) && product.price <= conf.maxPrice;

        return products.stream()
                .filter(product -> matchesConfig.test(product, config))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Problem 14: Build complex filtering system.
        List<Product> products = List.of(
                new Product("Electronics", 1200),
                new Product("Electronics", 800),
                new Product("Apparel", 50)
        );

        FilterConfig electronicsFilter = new FilterConfig("Electronics", 1000);
        List<Product> results = filterProducts(products, electronicsFilter);

        System.out.println("Products matching filter (Category=Electronics, MaxPrice=1000):");
        System.out.println(results);
    }
}

package stream.api.advance;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Sale {
    String region;
    String product;
    double amount;
    public Sale(String r, String p, double a) { region = r; product = p; amount = a; }
}

public class ReportEngine {
    public static void main(String[] args) {
        // Problem 11: Build stream-based report engine.
        List<Sale> sales = List.of(
                new Sale("NA", "Laptop", 1200),
                new Sale("EU", "Laptop", 1300),
                new Sale("NA", "Mouse", 25),
                new Sale("NA", "Laptop", 1250)
        );

        // Generate a complex report: Total sales amount per region.
        Map<String, Double> salesByRegion = sales.stream()
                .collect(Collectors.groupingBy(
                        sale -> sale.region,
                        Collectors.summingDouble(sale -> sale.amount)
                ));

        System.out.println("--- Sales Report by Region ---");
        salesByRegion.forEach((region, total) ->
            System.out.printf("Region: %s, Total Sales: $%.2f%n", region, total)
        );
    }
}

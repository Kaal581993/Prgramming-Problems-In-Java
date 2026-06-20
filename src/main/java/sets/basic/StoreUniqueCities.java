package sets.basic;

import java.util.HashSet;
import java.util.Set;

public class StoreUniqueCities {
    public static void main(String[] args) {
        // Problem 2: Store unique city names.
        Set<String> uniqueCities = new HashSet<>();
        uniqueCities.add("New York");
        uniqueCities.add("London");
        uniqueCities.add("Tokyo");
        uniqueCities.add("London"); // This duplicate will not be added
        uniqueCities.add("Paris");

        System.out.println("Unique city names: " + uniqueCities);
    }
}

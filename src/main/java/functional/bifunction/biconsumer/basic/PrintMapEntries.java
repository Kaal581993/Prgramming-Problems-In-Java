package functional.bifunction.biconsumer.basic;

import java.util.Map;
import java.util.function.BiConsumer;

public class PrintMapEntries {
    public static void main(String[] args) {
        // Problem 3: Print key-value pairs from map.
        Map<String, String> capitals = Map.of(
                "USA", "Washington, D.C.",
                "Japan", "Tokyo",
                "France", "Paris"
        );

        // Map.forEach takes a BiConsumer as its argument.
        BiConsumer<String, String> printEntry = (key, value) ->
                System.out.println("Country: " + key + ", Capital: " + value);

        capitals.forEach(printEntry);
    }
}

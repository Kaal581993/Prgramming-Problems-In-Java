package functional.bifunction.biconsumer.intermediate;

import java.util.Map;
import java.util.function.BiConsumer;

public class MapProcessor {

    // A generic method that processes each entry of a map using a BiConsumer.
    public static <K, V> void processMap(Map<K, V> map, BiConsumer<K, V> processor) {
        map.forEach(processor);
    }

    public static void main(String[] args) {
        // Problem 8: Create reusable map processor.
        Map<String, Integer> inventory = Map.of("Apples", 100, "Oranges", 150);

        // Define a specific action for processing inventory items
        BiConsumer<String, Integer> inventoryPrinter = (item, quantity) ->
                System.out.println("Item: " + item + ", Quantity: " + quantity);

        System.out.println("--- Current Inventory ---");
        processMap(inventory, inventoryPrinter);
    }
}

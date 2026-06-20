package map.linkedhashmap.basic;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByKeys {
    public static void main(String[] args) {
        // Problem 4: Sort map by keys.
        // A LinkedHashMap maintains insertion order, not key order.
        // To sort by key, we must convert it to a TreeMap.
        Map<String, Integer> insertionOrderMap = new LinkedHashMap<>();
        insertionOrderMap.put("Banana", 3);
        insertionOrderMap.put("Apple", 1);
        insertionOrderMap.put("Cherry", 2);

        System.out.println("LinkedHashMap (insertion order): " + insertionOrderMap);

        // Create a TreeMap to sort the entries by key
        Map<String, Integer> sortedMap = new TreeMap<>(insertionOrderMap);

        System.out.println("Sorted Map (by keys): " + sortedMap);
    }
}

package map.hashmap.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByKeys {
    public static void main(String[] args) {
        // Problem 4: Sort map by keys.
        // A HashMap itself is not sorted. To sort it, we can convert it to a TreeMap.
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Banana", 3);
        unsortedMap.put("Apple", 1);
        unsortedMap.put("Cherry", 2);

        System.out.println("Unsorted HashMap: " + unsortedMap);

        // Create a TreeMap from the HashMap to sort the entries by key
        Map<String, Integer> sortedMap = new TreeMap<>(unsortedMap);

        System.out.println("Sorted Map (by keys): " + sortedMap);
    }
}

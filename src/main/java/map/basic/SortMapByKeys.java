package map.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByKeys {
    public static void main(String[] args) {
        // Problem 4: Sort map by keys.
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Banana", 3);
        unsortedMap.put("Apple", 1);
        unsortedMap.put("Cherry", 2);

        System.out.println("Unsorted Map: " + unsortedMap);

        // A TreeMap automatically sorts entries by their keys
        Map<String, Integer> sortedMap = new TreeMap<>(unsortedMap);

        System.out.println("Sorted Map (by keys): " + sortedMap);
    }
}

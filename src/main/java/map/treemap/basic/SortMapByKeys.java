package map.treemap.basic;

import java.util.Map;
import java.util.TreeMap;

public class SortMapByKeys {
    public static void main(String[] args) {
        // Problem 4: Sort map by keys.
        // TreeMap is the ideal data structure for this problem as it's always sorted by key.
        Map<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Banana", 3);
        sortedMap.put("Apple", 1);
        sortedMap.put("Cherry", 2);

        System.out.println("TreeMap (always sorted by keys): " + sortedMap);
    }
}

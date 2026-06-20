package map.weakhashmap.basic;

import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class SortMapByKeys {
    public static void main(String[] args) {
        // Problem 4: Sort map by keys.
        // A WeakHashMap is not sorted. It must be transferred to a sorted map.
        Map<String, Integer> weakMap = new WeakHashMap<>();
        weakMap.put("Banana", 3);
        weakMap.put("Apple", 1);
        weakMap.put("Cherry", 2);

        System.out.println("WeakHashMap (unsorted): " + weakMap);

        // Create a TreeMap for a sorted view.
        Map<String, Integer> sortedMap = new TreeMap<>(weakMap);

        System.out.println("Sorted Map (by keys): " + sortedMap);
    }
}

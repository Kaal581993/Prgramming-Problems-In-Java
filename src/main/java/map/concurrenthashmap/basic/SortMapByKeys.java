package map.concurrenthashmap.basic;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class SortMapByKeys {
    public static void main(String[] args) {
        // Problem 4: Sort map by keys.
        // A ConcurrentHashMap is not sorted. To sort it, you must transfer it to a sorted map.
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("Banana", 3);
        concurrentMap.put("Apple", 1);
        concurrentMap.put("Cherry", 2);

        System.out.println("ConcurrentHashMap (unsorted): " + concurrentMap);

        // Create a TreeMap from the ConcurrentHashMap for a sorted view
        Map<String, Integer> sortedMap = new TreeMap<>(concurrentMap);

        System.out.println("Sorted Map (by keys): " + sortedMap);
    }
}

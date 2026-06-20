package map.concurrenthashmap.basic;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class MostFrequentNumber {
    public static void main(String[] args) {
        // Problem 5: Find most frequent number using ConcurrentHashMap.
        int[] numbers = {1, 3, 2, 3, 4, 1, 3, 5, 3, 2, 2, 2};
        // For high-contention updates, LongAdder is more performant than compute().
        Map<Integer, LongAdder> frequencyMap = new ConcurrentHashMap<>();

        // Process the numbers in parallel
        Arrays.stream(numbers).parallel().forEach(num -> {
            frequencyMap.computeIfAbsent(num, k -> new LongAdder()).increment();
        });

        Map.Entry<Integer, LongAdder> mostFrequent = null;
        for (Map.Entry<Integer, LongAdder> entry : frequencyMap.entrySet()) {
            if (mostFrequent == null || entry.getValue().sum() > mostFrequent.getValue().sum()) {
                mostFrequent = entry;
            }
        }

        System.out.println("Frequency Map: " + frequencyMap);
        System.out.println("The most frequent number is: " + mostFrequent.getKey());
    }
}

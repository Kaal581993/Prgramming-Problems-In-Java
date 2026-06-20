package map.treemap.basic;

import java.util.Map;
import java.util.TreeMap;

public class MostFrequentNumber {
    public static void main(String[] args) {
        // Problem 5: Find most frequent number using TreeMap.
        int[] numbers = {1, 3, 2, 3, 4, 1, 3, 5, 3, 2};
        // TreeMap will store the frequencies with the numbers (keys) in sorted order.
        Map<Integer, Integer> frequencyMap = new TreeMap<>();

        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int mostFrequentNumber = -1;
        int maxFrequency = -1;
        // The iteration will be in the natural order of the keys (1, 2, 3, 4, 5).
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentNumber = entry.getKey();
            }
        }

        System.out.println("Frequency Map (sorted by number): " + frequencyMap);
        System.out.println("The most frequent number is: " + mostFrequentNumber);
    }
}

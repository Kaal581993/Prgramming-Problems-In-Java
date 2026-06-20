package map.linkedhashmap.basic;

import java.util.LinkedHashMap;
import java.util.Map;

public class MostFrequentNumber {
    public static void main(String[] args) {
        // Problem 5: Find most frequent number using LinkedHashMap.
        int[] numbers = {1, 3, 2, 3, 4, 1, 3, 5, 3, 2};
        // LinkedHashMap will store the numbers in the order they first appeared.
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();

        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int mostFrequentNumber = -1;
        int maxFrequency = -1;
        // Iteration will be in the order of first appearance (1, 3, 2, 4, 5).
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentNumber = entry.getKey();
            }
        }

        System.out.println("Frequency Map (insertion order): " + frequencyMap);
        System.out.println("The most frequent number is: " + mostFrequentNumber);
    }
}

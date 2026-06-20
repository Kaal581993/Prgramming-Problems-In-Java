package map.hashmap.basic;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumber {
    public static void main(String[] args) {
        // Problem 5: Find most frequent number using HashMap.
        int[] numbers = {1, 3, 2, 3, 4, 1, 3, 5, 3, 2};
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int mostFrequentNumber = -1;
        int maxFrequency = -1;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentNumber = entry.getKey();
            }
        }

        System.out.println("The most frequent number is: " + mostFrequentNumber + " (appeared " + maxFrequency + " times)");
    }
}

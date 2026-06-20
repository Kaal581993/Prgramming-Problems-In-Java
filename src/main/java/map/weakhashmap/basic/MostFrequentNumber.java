package map.weakhashmap.basic;

import java.util.Map;
import java.util.WeakHashMap;

public class MostFrequentNumber {
    public static void main(String[] args) {
        // Problem 5: Find most frequent number using WeakHashMap.
        // Not a practical use case. Integer keys from -128 to 127 are cached.
        Map<Integer, Integer> frequencyMap = new WeakHashMap<>();
        int[] numbers = {1, 3, 2, 3, 4, 1, 3, 5, 3, 2};

        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        System.out.println("Frequency map will likely stay intact due to Integer caching.");
        System.out.println(frequencyMap);
    }
}

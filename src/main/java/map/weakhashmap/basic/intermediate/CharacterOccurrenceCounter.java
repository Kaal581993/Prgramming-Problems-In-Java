package map.weakhashmap.basic.intermediate;

import java.util.Map;
import java.util.WeakHashMap;

public class CharacterOccurrenceCounter {
    public static void main(String[] args) {
        // Problem 10: Count occurrences of characters using WeakHashMap.
        // Not a practical use case.
        Map<Character, Integer> charCounts = new WeakHashMap<>();
        String text = "hello world";

        for (char c : text.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        System.out.println("Counts before GC: " + charCounts);
        System.gc();
        System.out.println("Counts after GC (likely unchanged due to Character caching): " + charCounts);
    }
}

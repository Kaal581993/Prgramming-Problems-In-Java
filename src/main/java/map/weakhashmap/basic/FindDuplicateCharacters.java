package map.weakhashmap.basic;

import java.util.Map;
import java.util.WeakHashMap;

public class FindDuplicateCharacters {
    public static void main(String[] args) {
        // Problem 3: Find duplicate characters using WeakHashMap.
        // This is not a practical use case for WeakHashMap as Character objects are often cached.
        Map<Character, Integer> charCounts = new WeakHashMap<>();
        
        String input = "programming";
        for (char c : input.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Because Character objects between -128 and 127 are cached, they are unlikely to be GC'd.
        // The map will likely remain intact.
        System.out.println("Character counts: " + charCounts);
        System.gc();
        System.out.println("Character counts after GC: " + charCounts);
    }
}

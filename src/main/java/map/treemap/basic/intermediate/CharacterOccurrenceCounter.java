package map.treemap.basic.intermediate;

import java.util.Map;
import java.util.TreeMap;

public class CharacterOccurrenceCounter {
    public static void main(String[] args) {
        // Problem 10: Count occurrences of characters using TreeMap.
        String text = "hello world";
        // TreeMap is perfect for this to get a sorted view of character counts.
        Map<Character, Integer> charCounts = new TreeMap<>();

        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) continue;
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character occurrences in '" + text + "' (sorted):");
        System.out.println(charCounts);
    }
}

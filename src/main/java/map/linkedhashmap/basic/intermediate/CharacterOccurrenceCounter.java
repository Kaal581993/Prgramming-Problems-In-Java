package map.linkedhashmap.basic.intermediate;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterOccurrenceCounter {
    public static void main(String[] args) {
        // Problem 10: Count occurrences of characters using LinkedHashMap.
        String text = "hello world";
        // LinkedHashMap is perfect for getting a count of characters in their order of appearance.
        Map<Character, Integer> charCounts = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) continue;
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character occurrences in '" + text + "' (in order of appearance):");
        System.out.println(charCounts);
    }
}

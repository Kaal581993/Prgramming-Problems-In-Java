package map.hashmap.basic.intermediate;

import java.util.HashMap;
import java.util.Map;

public class CharacterOccurrenceCounter {
    public static void main(String[] args) {
        // Problem 10: Count occurrences of characters using HashMap.
        String text = "hello world";
        Map<Character, Integer> charCounts = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) continue;
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character occurrences in '" + text + "': " + charCounts);
    }
}

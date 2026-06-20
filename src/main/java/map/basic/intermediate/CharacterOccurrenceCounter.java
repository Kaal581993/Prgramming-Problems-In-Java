package map.basic.intermediate;

import java.util.Map;
import java.util.TreeMap;

public class CharacterOccurrenceCounter {
    public static void main(String[] args) {
        // Problem 10: Count occurrences of characters.
        String text = "hello world";
        // Using a TreeMap to keep the character counts sorted alphabetically
        Map<Character, Integer> charCounts = new TreeMap<>();

        for (char c : text.toCharArray()) {
            // Skip whitespace for this example
            if (Character.isWhitespace(c)) {
                continue;
            }
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character occurrences in '" + text + "':");
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }
    }
}

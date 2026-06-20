package map.linkedhashmap.basic;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindDuplicateCharacters {
    public static void main(String[] args) {
        // Problem 3: Find duplicate characters using LinkedHashMap.
        String input = "programming";
        // LinkedHashMap will maintain the order of first appearance of characters.
        Map<Character, Integer> charCounts = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        System.out.println("Duplicate characters (in order of appearance):");
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
            }
        }
    }
}

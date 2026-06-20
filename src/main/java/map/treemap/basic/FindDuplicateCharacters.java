package map.treemap.basic;

import java.util.Map;
import java.util.TreeMap;

public class FindDuplicateCharacters {
    public static void main(String[] args) {
        // Problem 3: Find duplicate characters using TreeMap.
        String input = "programming";
        // Using a TreeMap will store character counts sorted by character.
        Map<Character, Integer> charCounts = new TreeMap<>();

        for (char c : input.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        System.out.println("Duplicate characters (in alphabetical order):");
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
            }
        }
    }
}

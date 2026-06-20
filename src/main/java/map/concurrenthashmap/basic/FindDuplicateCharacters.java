package map.concurrenthashmap.basic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FindDuplicateCharacters {
    public static void main(String[] args) {
        // Problem 3: Find duplicate characters using ConcurrentHashMap.
        String input = "programming in parallel is fun";
        Map<Character, Integer> charCounts = new ConcurrentHashMap<>();

        // Use a parallel stream to process the characters concurrently
        input.chars().parallel().forEach(c -> {
            if (!Character.isWhitespace((char) c)) {
                charCounts.compute((char) c, (key, val) -> (val == null) ? 1 : val + 1);
            }
        });

        System.out.println("Character counts: " + charCounts);
        System.out.println("\nDuplicate characters:");
        charCounts.forEach((character, count) -> {
            if (count > 1) {
                System.out.println(character + ": " + count + " times");
            }
        });
    }
}

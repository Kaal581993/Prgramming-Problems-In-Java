package map.concurrenthashmap.intermediate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CharacterOccurrenceCounter {
    public static void main(String[] args) {
        // Problem 10: Count occurrences of characters concurrently.
        String text = "this is a test string for concurrent character counting";
        Map<Character, Integer> charCounts = new ConcurrentHashMap<>();

        text.chars().parallel().forEach(c -> {
            if (!Character.isWhitespace((char) c)) {
                charCounts.compute((char) c, (k, v) -> (v == null) ? 1 : v + 1);
            }
        });

        System.out.println("Character occurrences from parallel execution:");
        System.out.println(charCounts);
    }
}

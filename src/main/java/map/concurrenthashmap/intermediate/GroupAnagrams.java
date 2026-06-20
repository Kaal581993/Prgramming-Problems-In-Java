package map.concurrenthashmap.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GroupAnagrams {
    public static void main(String[] args) {
        // Problem 7: Group anagrams using ConcurrentHashMap in parallel.
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // The list must also be thread-safe, e.g., CopyOnWriteArrayList.
        Map<String, List<String>> anagramGroups = new ConcurrentHashMap<>();

        Arrays.stream(words).parallel().forEach(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            anagramGroups.computeIfAbsent(sortedWord, k -> new CopyOnWriteArrayList<>()).add(word);
        });

        System.out.println("Anagram groups (from parallel execution):");
        System.out.println(anagramGroups);
    }
}

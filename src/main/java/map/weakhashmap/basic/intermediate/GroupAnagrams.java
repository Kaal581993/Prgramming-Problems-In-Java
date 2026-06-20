package map.weakhashmap.basic.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class GroupAnagrams {
    public static void main(String[] args) {
        // Problem 7: Group anagrams using WeakHashMap.
        // Not a practical use case. The sorted string keys are temporary and could be GC'd,
        // but string literals in the source array will keep them alive.
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> anagramGroups = new WeakHashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            anagramGroups.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }

        System.out.println("Anagram groups (map may be empty after GC if keys were not referenced):");
        System.out.println(anagramGroups);
    }
}

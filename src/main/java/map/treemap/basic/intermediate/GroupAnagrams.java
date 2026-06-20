package map.treemap.basic.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GroupAnagrams {
    public static void main(String[] args) {
        // Problem 7: Group anagrams using TreeMap.
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // Using a TreeMap will store the anagram groups sorted by the key (the sorted word).
        Map<String, List<String>> anagramGroups = new TreeMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            anagramGroups.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }

        System.out.println("Anagram groups (sorted by key 'aet', 'ant', 'abt'):");
        for (Map.Entry<String, List<String>> entry : anagramGroups.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

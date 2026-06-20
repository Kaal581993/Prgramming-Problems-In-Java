package map.linkedhashmap.basic.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        // Problem 7: Group anagrams using LinkedHashMap.
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // Using LinkedHashMap will preserve the order of the anagram groups as they are found.
        Map<String, List<String>> anagramGroups = new LinkedHashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            anagramGroups.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }

        System.out.println("Anagram groups (in order of discovery 'aet', 'ant', 'abt'):");
        anagramGroups.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

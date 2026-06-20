package map.linkedhashmap.basic;

import java.util.LinkedHashMap;
import java.util.Map;

public class WordsFrequency {
    public static void main(String[] args) {
        // Problem 1: Count frequency of words using LinkedHashMap.
        String text = "the quick brown fox jumps over the lazy dog the fox";
        // LinkedHashMap maintains the insertion order of the keys.
        Map<String, Integer> wordFrequencies = new LinkedHashMap<>();

        String[] words = text.split(" ");

        for (String word : words) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies (in order of first appearance): " + wordFrequencies);
    }
}

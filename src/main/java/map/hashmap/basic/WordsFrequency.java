package map.hashmap.basic;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {
    public static void main(String[] args) {
        // Problem 1: Count frequency of words using HashMap.
        String text = "the quick brown fox jumps over the lazy dog the fox";
        // HashMap is a good choice here as it provides fast O(1) average time complexity for insertions and lookups.
        Map<String, Integer> wordFrequencies = new HashMap<>();

        String[] words = text.split(" ");

        for (String word : words) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies (order is not guaranteed): " + wordFrequencies);
    }
}

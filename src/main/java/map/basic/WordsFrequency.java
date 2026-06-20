package map.basic;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {
    public static void main(String[] args) {
        // Problem 1: Count frequency of words.
        String text = "the quick brown fox jumps over the lazy dog";
        Map<String, Integer> wordFrequencies = new HashMap<>();

        String[] words = text.split(" ");

        for (String word : words) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies: " + wordFrequencies);
    }
}

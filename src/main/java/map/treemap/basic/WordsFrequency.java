package map.treemap.basic;

import java.util.Map;
import java.util.TreeMap;

public class WordsFrequency {
    public static void main(String[] args) {
        // Problem 1: Count frequency of words using TreeMap.
        String text = "the quick brown fox jumps over the lazy dog the fox";
        // TreeMap will store the words in natural (alphabetical) order.
        Map<String, Integer> wordFrequencies = new TreeMap<>();

        String[] words = text.split(" ");

        for (String word : words) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies (sorted by word): " + wordFrequencies);
    }
}

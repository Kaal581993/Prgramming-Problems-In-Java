package sets.basic;

import java.util.HashSet;
import java.util.Set;

public class CountUniqueWords {
    public static void main(String[] args) {
        // Problem 3: Count unique words in paragraph.
        String paragraph = "The quick brown fox jumps over the lazy dog. The quick brown fox is fast.";
        String[] words = paragraph.toLowerCase().split("\\W+");

        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println("The paragraph is: '" + paragraph + "'");
        System.out.println("Number of unique words: " + uniqueWords.size());
        System.out.println("Unique words: " + uniqueWords);
    }
}

package sets.basic.intermediate.advance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SpellChecker {
    private final Set<String> dictionary;

    public SpellChecker(String... words) {
        dictionary = new HashSet<>(Arrays.asList(words));
    }

    public boolean isSpelledCorrectly(String word) {
        return dictionary.contains(word.toLowerCase());
    }

    public void checkText(String text) {
        System.out.println("Checking text: \"" + text + "\"");
        String[] words = text.toLowerCase().split("\\W+");
        boolean allCorrect = true;
        for (String word : words) {
            if (!isSpelledCorrectly(word)) {
                System.out.println("Misspelled word found: " + word);
                allCorrect = false;
            }
        }
        if (allCorrect) {
            System.out.println("All words are spelled correctly.");
        }
    }

    public static void main(String[] args) {
        // Problem 14: Build spell checker.
        SpellChecker spellChecker = new SpellChecker("hello", "world", "java", "is", "fun");

        spellChecker.checkText("Hello world, Java is fun!");
        spellChecker.checkText("Hello wurld, this is a test.");
    }
}

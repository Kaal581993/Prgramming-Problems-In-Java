package sets.basic.intermediate.advance;

import java.util.SortedSet;
import java.util.TreeSet;

public class AutocompleteWithTreeSet {
    private final TreeSet<String> dictionary = new TreeSet<>();

    public AutocompleteWithTreeSet(String[] words) {
        for (String word : words) {
            dictionary.add(word.toLowerCase());
        }
    }

    public SortedSet<String> suggest(String prefix) {
        prefix = prefix.toLowerCase();
        // The "to" part of the subSet is exclusive, so we find the next possible string
        // by appending a character with a value just after the last character of the prefix.
        // A common trick is to use a character with ASCII value 0, but that's not printable.
        // A simpler way is to find the string that would come right after all strings starting with the prefix.
        String endPrefix = prefix + Character.MAX_VALUE;
        
        return dictionary.subSet(prefix, endPrefix);
    }

    public static void main(String[] args) {
        // Problem 13: Implement autocomplete using TreeSet.
        String[] words = {"apple", "apricot", "application", "banana", "bandana", "cat", "catalog"};
        AutocompleteWithTreeSet autocomplete = new AutocompleteWithTreeSet(words);

        String prefix1 = "ap";
        System.out.println("Suggestions for '" + prefix1 + "': " + autocomplete.suggest(prefix1));

        String prefix2 = "ban";
        System.out.println("Suggestions for '" + prefix2 + "': " + autocomplete.suggest(prefix2));
        
        String prefix3 = "cata";
        System.out.println("Suggestions for '" + prefix3 + "': " + autocomplete.suggest(prefix3));
    }
}

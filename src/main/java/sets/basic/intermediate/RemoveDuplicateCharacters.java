package sets.basic.intermediate;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        // Problem 10: Remove duplicate characters from string.
        String input = "programming";
        System.out.println("Original string: " + input);

        // Use a LinkedHashSet to maintain the order of characters
        Set<Character> charSet = new LinkedHashSet<>();
        for (char c : input.toCharArray()) {
            charSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : charSet) {
            sb.append(c);
        }

        System.out.println("String after removing duplicates: " + sb.toString());
    }
}

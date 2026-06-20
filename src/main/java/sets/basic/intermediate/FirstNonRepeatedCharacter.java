package sets.basic.intermediate;

import java.util.HashSet;
import java.util.Set;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        // Problem 7: Find first non-repeated character.
        String input = "swiss";
        System.out.println("The input string is: '" + input + "'");

        Set<Character> repeating = new HashSet<>();
        Set<Character> nonRepeating = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (repeating.contains(c)) {
                continue;
            }
            if (nonRepeating.contains(c)) {
                nonRepeating.remove(c);
                repeating.add(c);
            } else {
                nonRepeating.add(c);
            }
        }

        if (!nonRepeating.isEmpty()) {
            // To find the *first* one, we need to iterate through the string again
            for (int i = 0; i < input.length(); i++) {
                if (nonRepeating.contains(input.charAt(i))) {
                    System.out.println("The first non-repeated character is: " + input.charAt(i));
                    return;
                }
            }
        } else {
            System.out.println("No non-repeated characters found.");
        }
    }
}

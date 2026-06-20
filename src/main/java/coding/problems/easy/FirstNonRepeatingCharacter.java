package coding.problems.easy;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String input = "Swiss";
        String processorString = input.toLowerCase().toString();
        char result = findFirstNonRepeatingChar(processorString);
        
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found");
        }
    }
    
    /**
     * Finds the first non-repeating character in a string using HashMap.
     * 
     * Algorithm:
     * 1. Count the frequency of each character using HashMap
     * 2. Iterate through the string again to find the first character with count 1
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is the number of unique characters
     * 
     * @param str the input string
     * @return the first non-repeating character, or '\0' if none exists
     */
    public static char findFirstNonRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return '\0';
        }
        
        // Step 1: Count character frequencies
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCountMap.put(
                    ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
        
        // Step 2: Find the first character with count 1
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (charCountMap.get(ch) == 1) {
                return ch;
            }
        }
        
        return '\0'; // No non-repeating character found
    }
}

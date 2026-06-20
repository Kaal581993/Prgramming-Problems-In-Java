package coding.problems.easy;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateFromString {

    public static void main(String[] args) {
        String input = "programming";
        
        // Method 1: Using LinkedHashSet
        String result1 = removeDuplicatesUsingLinkedHashSet(input);
        System.out.println("Method 1 (LinkedHashSet): " + result1);
        
        // Method 2: Using Streams
        String result2 = removeDuplicatesUsingStreams(input);
        System.out.println("Method 2 (Streams): " + result2);
    }
    
    /**
     * Removes duplicate characters from a string using LinkedHashSet.
     * 
     * LinkedHashSet maintains insertion order, so the first occurrence of each
     * character is preserved in the original order.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is the number of unique characters
     * 
     * @param str the input string
     * @return string with duplicate characters removed
     */
    public static String removeDuplicatesUsingLinkedHashSet(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        // Convert string to char array, add to LinkedHashSet, then back to string
        Set<Character> uniqueChars = new LinkedHashSet<>();
        
        for (int i = 0; i < str.length(); i++) {
            uniqueChars.add(str.charAt(i));
            System.out.println(uniqueChars);
        }
        
        // Build the result string
        StringBuilder result = new StringBuilder();
        for (Character ch : uniqueChars) {
            result.append(ch);
            System.out.println(result);
        }
        
        return result.toString();
    }
    
    /**
     * Removes duplicate characters from a string using Java Streams.
     * 
     * Uses LinkedHashSet as a collector to maintain insertion order.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is the number of unique characters
     * 
     * @param str the input string
     * @return string with duplicate characters removed
     */
    public static String removeDuplicatesUsingStreams(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .collect(StringBuilder::new, 
                         StringBuilder::append, 
                         StringBuilder::append)
                .toString();
    }
}
package functional.predicate.basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindPalindromes {
    public static void main(String[] args) {
        // Problem 4: Find palindrome strings using Predicate.
        Predicate<String> isPalindrome = str -> {
            String reversed = new StringBuilder(str).reverse().toString();
            return str.equals(reversed);
        };

        List<String> strings = Arrays.asList("madam", "level", "hello", "racecar", "world");
        System.out.println("Original list: " + strings);

        List<String> palindromes = strings.stream()
                .filter(isPalindrome)
                .collect(Collectors.toList());

        System.out.println("Palindromes in the list: " + palindromes);
    }
}

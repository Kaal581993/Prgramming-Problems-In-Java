package coding.problems.easy.intermediate.advance.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class LogestPalindromicSubString {

    public static void main(String[] args) {

        String input = "babad";

        System.out.println(longestPalindromeSubStringStreams(input));
    }

    private static String longestPalindromeSubStringStreams(String s) {
        if (s == null || s.isEmpty()) {
            return "No String value";
        }



//        String longestPalindromeSubStringPalindromeSubString =
//                Stream.of(0, s.length())
//                        .flatMap(
//                                i -> {
//                                    String[] stringArray = new String[]
//                                            {s.substring(0, i)};
//                                    String[] reversed = new String[]{
//                                            new StringBuilder(
//                                                    stringArray[i])
//                                                    .reverse()
//                                                    .toString()};
//
//                                    String[] palindromeStrings = null;
//                                    if (stringArray[i].equals(reversed[i])) {
//                                        palindromeStrings = new String[]{
//                                                stringArray[i]};
//                                    }
//
//                                    String longestPalindrome = Arrays.stream(palindromeStrings)
//                                            .max(Comparator.comparingInt(String::length))
//                                            .orElse("");
//
////                                    System.out.println(longestPalindrome);
//                                    return Stream.of(longestPalindrome);
//
//                                }).toString();


             // 1. Generate all combinations of start
             // and end indices using IntStream
        return IntStream.range(0, s.length())
                .boxed()
                .flatMap(
                        start -> IntStream
                                .rangeClosed(start + 1, s.length())
                        .mapToObj(end ->
                                s.substring(start, end)))

                // 2. Filter out strings that are NOT palindromes
                .filter(sub ->
                    sub.equals(
                        new StringBuilder(sub)
                            .reverse()
                            .toString()))

                // 3. TERMINAL OPERATION: Compare lengths and pull
                // the max out of the stream
                .max(Comparator
                        .comparingInt(
                            String::length
                        ))

                // 4. Safely handle the result container
                .orElse("");
    }
}

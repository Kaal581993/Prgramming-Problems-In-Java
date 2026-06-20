package stream.api.basic.intermediate;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Problem 10: Count word frequency.
        String text = "the quick brown fox jumps over the lazy dog";

        Map<String, Long> wordFrequency = Arrays.stream(text.split(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(), // Group by the word itself
                        Collectors.counting()  // Count the occurrences in each group
                ));

        System.out.println("Word frequency map:");
        System.out.println(wordFrequency);
    }
}

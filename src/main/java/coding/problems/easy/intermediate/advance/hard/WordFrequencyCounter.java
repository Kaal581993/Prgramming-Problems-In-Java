package coding.problems.easy.intermediate.advance.hard;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String sentence = "This is java and java is powerful";

//        List<String> words = new ArrayList<>(
//                List.of(sentence.toLowerCase().split(" "))
//        );
// This implementation uses 2 objects resulting in Higher memory consumption
        //Below is the lower memory consuption + Array wrapping feature
        List<String> words = Arrays.stream(sentence.toLowerCase().split(" "))
                .collect(Collectors.toList());


        System.out.println(words);
        System.out.println();

//        HashMap<List<List<String>>, Long> wordCounter = new HashMap<>(
//                Map.ofEntries(
//                        entry(List.of(words),words.stream().count())
//                )
//        );

        // Group by each word and count its frequency
        Map<String, Long> wordCounter = words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
        System.out.println("Word Counts: " + wordCounter+"\n");


        Map<String, Long> wordCounter2 = new HashMap<>();
        for (String word : words) {
            // Increments the count by 1, or initializes
            // it to 1 if it doesn't exist yet
            wordCounter2.merge(word, 1L, Long::sum);
        }
        System.out.println("Word Counts: " + wordCounter2);


        //3rd approach:

        // 2. Count the frequency of each word
//        Map<String, Long> wordCounter = words.stream()
//                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        // 3. Sort by count (descending) and then by last occurrence index (ascending)
        wordCounter.entrySet().stream()
                .sorted((e1, e2) -> {
                    // Compare counts descending
                    int countCompare =
                            e2.getValue()
                                    .compareTo(e1.getValue());
                    if (countCompare != 0) {
                        return countCompare;
                    }
                    // Tie-breaker: sort by last index of occurrence in the original list
                    return Integer.compare(
                            words.lastIndexOf(e1.getKey()),
                            words.lastIndexOf(e2.getKey()));
                })
                // 4. Print each entry in the "key=value" format
                .forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));



    //4th approach


    }

}


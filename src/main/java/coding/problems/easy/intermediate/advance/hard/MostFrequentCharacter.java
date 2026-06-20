package coding.problems.easy.intermediate.advance.hard;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MostFrequentCharacter {





public static void main(String[] args) {

        String word ="success";

        Stream<Character> charStream = word.chars()
                .mapToObj(c -> (char) c);


      //  System.out.println(Arrays.toString(charStream.toArray()));
        // Why doe this print: [Ljava.lang.Object;@45dd4eda
// Why cant it print as an character and how to print it in characters

     //   System.out.println(Arrays.toString(charStream.toArray()));
        // stream can be processed only once hence commented out
// Output: [s, u, c, c, e, s, s]


        Map<Character, Long> frequencyMap = charStream
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(frequencyMap);

        Optional<Entry<Character, Long>> highestFrequencyCount = frequencyMap
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        System.out.println("Highest Frequency count: "+highestFrequencyCount);
    }
}

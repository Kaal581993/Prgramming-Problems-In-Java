package coding.problems.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFrequencyElements {
    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<>(List.of(
                1,2,2,3,3,3
        ));

        Map<Integer, Long> frequencyMap =
                numList.stream()
                .collect(Collectors.groupingBy(
                        num -> num,         // key mapper: the element itself
                        Collectors.counting()     // value mapper: count occurrences
                ));

// Print all frequencies
        frequencyMap.forEach((num, count) ->
                System.out.println(num + " -> " + count)
        );




    }
}

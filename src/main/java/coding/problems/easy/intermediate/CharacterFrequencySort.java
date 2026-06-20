package coding.problems.easy.intermediate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharacterFrequencySort {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of(
                "tree","bee","ghee","see","funny","cattle","Battle"
        ));


        Map<Character, Long> stringMap = new HashMap<>();

        for (int i=0;i<stringList.size();i++) {
            Map<Character, Long> frequencyMap = stringList.get(i).chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()
                    ));
            System.out.println(frequencyMap);

            // Step 2: Sort by frequency (descending) and build result
            String result = frequencyMap.entrySet()
                    .stream()
                    .sorted(
                            Map.Entry.<Character, Long>
                                    comparingByValue().reversed())
                    .flatMap(entry -> {
                        char ch = entry.getKey();
                        long count = entry.getValue();
                        return String.valueOf(ch).repeat((int) count).chars()
                                .mapToObj(c -> (char) c);
                    })
                    .collect(StringBuilder::new,
                            (sb, ch) -> sb.append(ch),
                            StringBuilder::append)
                    .toString();

            System.out.println("Input: " + stringList.get(i));
            System.out.println("Output: " + result);

        }





        //System.out.println("stringMap list: \n"+stringMap);



    }
}

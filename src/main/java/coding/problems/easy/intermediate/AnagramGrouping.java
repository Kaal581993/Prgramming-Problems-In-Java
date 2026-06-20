package coding.problems.easy.intermediate;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramGrouping {

    public static void main(String[] args) {

        String[] words = {"ABC","CBA","DOG","GOD","CAT","ACT"};

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            // Convert string to char array
            char[] chars = word.toCharArray();
            // Sort characters

            Arrays.sort(chars);
            // Create key
            System.out.println(chars)
            ;
            String key = new String(chars);
            // Add to map
            map.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(word);
            System.out.println(map);
        }

        // Print grouped strings
        System.out.println(new ArrayList<>(map.values()));

        System.out.println("\n using Streams and collection\n");

        Collection<List<String>> result =
                Arrays.stream(words)
                        .collect(
                                Collectors.groupingBy(
                                        word -> {
                            char[] chars = word.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }))
                        .values();

        System.out.println(result);



        System.out.println("\n using Streams and List\n");


        List<List<String>> resultList = Arrays.stream(words)
                .collect(
                        Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }))
                .values()
                .stream()
                .collect(Collectors.toList());

        System.out.println(resultList);

    }
}

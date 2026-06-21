package patterns.traversal.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StreamTraversalPattern {
    public static void main(String[] args) {
        List<String>
                names =
                Arrays.asList("John", "Mike", "David");

        names.stream()
                .forEach(System.out::println);

        Map<Integer, String> map =
                new HashMap<>();

        map.put(1, "John");
        map.put(2, "Mike");
        map.put(3, "David");

        //Pattern 2: map()

        //Transform elements.

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        names.stream()
                .filter(name -> name.startsWith("J"))
                .forEach(System.out::println);

        List<List<Integer>> data =
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(3, 4)
                );

        data.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        IntStream.range(0, names.size())
                .forEach(i ->
                        System.out.println(
                                i + " -> "
                                        + names.get(i)));
    }
}

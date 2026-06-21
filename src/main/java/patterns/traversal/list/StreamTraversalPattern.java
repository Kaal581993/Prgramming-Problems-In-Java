package patterns.traversal.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }
}

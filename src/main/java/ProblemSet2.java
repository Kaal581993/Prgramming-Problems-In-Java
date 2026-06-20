import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProblemSet2 {

    /**
     *Given a list of strings, group them by their length,
     * and then find the longest string in each group.
     * Input: ["apple", "bat", "car", "banana", "kiwi", "cherry"]
     * Output: {3="car", 4="kiwi", 5="apple", 6="banana"}
     * (or "bat" for length 3, and "cherry" for length 6,
     * depending on which one is picked)
     * */

    public static void main(String[] args) {

        List<String> strarr = List.of("apple", "bat", "car", "banana", "kiwi", "cherry");

        Map<Integer, String> result = strarr.stream()
                .collect(Collectors.toMap(
                        String::length,      // Key: the length of the string
                        s -> s,              // Value: the string itself
                        (existing, replacement) -> existing
                        // Merge function: if a key exists, keep the existing value
                ));

        System.out.println(result);
    }
}

package patterns.traversal.list;

import java.util.HashMap;
import java.util.Map;

public class MapTraversalPattern {
    public static void main(String[] args) {
        Map<Integer, String> map =
                new HashMap<>();

        map.put(1, "John");
        map.put(2, "Mike");
        map.put(3, "David");

        //Pattern 1: entrySet()

        //Most Efficient

        for (Map.Entry<Integer, String> entry
                : map.entrySet()) {

            System.out.println(
                    entry.getKey()
                            + " "
                            + entry.getValue());
        }

        //Pattern 2: keySet()
        for (Integer key : map.keySet()) {
            System.out.println(
                    key + " " + map.get(key));
        }

        // Less efficient.

        //Pattern 3: values()
        for (String value : map.values()) {
            System.out.println(value);
        }

        //Pattern 4: forEach()
        map.forEach((key, value) ->
                System.out.println(key + " " + value));


    }
}

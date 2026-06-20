package functional.function.intermediate;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListToUppercase {
    public static void main(String[] args) {
        // Problem 7: Convert list of names to uppercase.
        List<String> names = List.of("Alice", "Bob", "Charlie");
        
        // The function to be applied to each element in the stream.
        Function<String, String> toUppercase = String::toUpperCase;

        List<String> uppercaseNames = names.stream()
                .map(toUppercase)
                .collect(Collectors.toList());

        System.out.println("Original list: " + names);
        System.out.println("Uppercase list: " + uppercaseNames);
    }
}

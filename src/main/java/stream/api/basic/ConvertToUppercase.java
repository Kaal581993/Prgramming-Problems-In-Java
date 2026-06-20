package stream.api.basic;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertToUppercase {
    public static void main(String[] args) {
        // Problem 2: Convert names to uppercase.
        List<String> names = List.of("Alice", "Bob", "Charlie");

        List<String> uppercaseNames = names.stream()
                .map(String::toUpperCase) // A function to transform each element
                .collect(Collectors.toList());

        System.out.println("Original names: " + names);
        System.out.println("Uppercase names: " + uppercaseNames);
    }
}

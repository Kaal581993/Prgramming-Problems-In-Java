package functional.function.intermediate;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformationUtility {

    // A generic method that applies a transformation function to a list of items.
    public static <T, R> List<R> transformList(List<T> list, Function<T, R> transformer) {
        return list.stream()
                   .map(transformer)
                   .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Problem 10: Implement reusable transformation utility.
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<Integer> numbers = List.of(1, 2, 3, 4);

        // Define a function to get the length of a string
        Function<String, Integer> nameLengthTransformer = String::length;

        // Define a function to get the square of a number
        Function<Integer, Integer> squareTransformer = n -> n * n;

        List<Integer> nameLengths = transformList(names, nameLengthTransformer);
        System.out.println("Lengths of names: " + nameLengths);

        List<Integer> squares = transformList(numbers, squareTransformer);
        System.out.println("Squares of numbers: " + squares);
    }
}

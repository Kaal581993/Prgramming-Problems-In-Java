package functional.function.intermediate;

import java.util.function.Function;

public class ChainFunctions {
    public static void main(String[] args) {
        // Problem 9: Chain multiple functions.
        Function<String, String> removeWhitespace = str -> str.replaceAll("\\s+", "");
        Function<String, String> toUppercase = String::toUpperCase;
        Function<String, String> addPrefix = str -> "PREFIX_" + str;

        // Chain the functions: removeWhitespace -> toUppercase -> addPrefix
        // andThen() applies the function it's called on first, then the function passed as an argument.
        Function<String, String> chainedFunction = removeWhitespace
                .andThen(toUppercase)
                .andThen(addPrefix);

        String input = "  hello world  ";
        String result = chainedFunction.apply(input);

        System.out.println("Original: '" + input + "'");
        System.out.println("Result after chaining: '" + result + "'");
    }
}

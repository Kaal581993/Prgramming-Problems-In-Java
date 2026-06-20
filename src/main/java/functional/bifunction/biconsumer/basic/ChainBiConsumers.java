package functional.bifunction.biconsumer.basic;

import java.util.function.BiConsumer;

public class ChainBiConsumers {
    public static void main(String[] args) {
        // Problem 5: Chain two BiConsumers.
        BiConsumer<String, String> printConcatenated = (s1, s2) -> System.out.println("Concatenated: " + s1 + s2);
        BiConsumer<String, String> printLengths = (s1, s2) ->
                System.out.println("Lengths: " + s1.length() + ", " + s2.length());

        // Chain them together
        BiConsumer<String, String> chainedConsumer = printConcatenated.andThen(printLengths);

        chainedConsumer.accept("Hello", "World");
    }
}

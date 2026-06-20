package functional.consumer.basic;

import java.util.function.Consumer;

public class ChainConsumers {
    public static void main(String[] args) {
        // Problem 5: Chain two consumers.
        Consumer<String> toUppercase = str -> System.out.println("Uppercase: " + str.toUpperCase());
        Consumer<String> printLength = str -> System.out.println("Length: " + str.length());

        // Chain them together. toUppercase will execute first, then printLength.
        Consumer<String> chainedConsumer = toUppercase.andThen(printLength);

        chainedConsumer.accept("hello world");
    }
}

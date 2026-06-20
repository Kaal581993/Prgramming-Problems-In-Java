package functional.bifunction.biconsumer.advance;

import java.util.function.BiConsumer;

// A simplified simulation of zipping two streams together.
class StreamZipper<T, U> {
    private final BiConsumer<T, U> onZip;

    public StreamZipper(BiConsumer<T, U> onZip) {
        this.onZip = onZip;
    }

    // In a real reactive library, this would be handled by the library's scheduler.
    public void accept(T value1, U value2) {
        onZip.accept(value1, value2);
    }
}

public class ReactiveStreamConsumer {
    public static void main(String[] args) {
        // Problem 15: Implement reactive stream consumer (zipping).
        
        // This BiConsumer defines what to do when an item from each stream is available.
        BiConsumer<String, Integer> zippedAction = (text, number) -> {
            System.out.println("Zipped -> Text: " + text + ", Number: " + number);
        };

        StreamZipper<String, Integer> zipper = new StreamZipper<>(zippedAction);

        // Simulate data arriving from two different streams
        System.out.println("Simulating zipped streams...");
        zipper.accept("A", 1);
        zipper.accept("B", 2);
        zipper.accept("C", 3);
    }
}

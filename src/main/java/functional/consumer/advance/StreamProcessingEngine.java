package functional.consumer.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// A simplified stream-like processing pipeline
class DataStream<T> {
    private List<T> data;

    private DataStream(List<T> data) {
        this.data = data;
    }

    public static <T> DataStream<T> of(List<T> data) {
        return new DataStream<>(data);
    }

    public DataStream<T> filter(Predicate<T> predicate) {
        List<T> filteredData = new ArrayList<>();
        for (T item : data) {
            if (predicate.test(item)) {
                filteredData.add(item);
            }
        }
        return new DataStream<>(filteredData);
    }

    public <R> DataStream<R> map(Function<T, R> function) {
        List<R> mappedData = new ArrayList<>();
        for (T item : data) {
            mappedData.add(function.apply(item));
        }
        return new DataStream<>(mappedData);
    }

    // The terminal operation that consumes the final data
    public void forEach(Consumer<T> consumer) {
        for (T item : data) {
            consumer.accept(item);
        }
    }
}

public class StreamProcessingEngine {
    public static void main(String[] args) {
        // Problem 13: Create stream processing engine.
        List<String> names = List.of("Alice", "Bob", "Charlie", "Anna");

        // The consumer is the final step in the pipeline, printing the result.
        Consumer<String> printAction = System.out::println;

        DataStream.of(names)
                  .filter(name -> name.startsWith("A"))
                  .map(String::toUpperCase)
                  .forEach(printAction);
    }
}

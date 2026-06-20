package functional.function.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// A simplified stream-like processing pipeline
class DataStream<T> {
    private List<T> data;

    private DataStream(List<T> data) { this.data = data; }

    public static <T> DataStream<T> of(List<T> data) { return new DataStream<>(data); }

    public DataStream<T> filter(Predicate<T> predicate) {
        List<T> filteredData = new ArrayList<>();
        for (T item : data) { if (predicate.test(item)) { filteredData.add(item); } }
        return new DataStream<>(filteredData);
    }

    // The 'map' operation is a core use case for the Function interface.
    public <R> DataStream<R> map(Function<T, R> function) {
        List<R> mappedData = new ArrayList<>();
        for (T item : data) { mappedData.add(function.apply(item)); }
        return new DataStream<>(mappedData);
    }

    public void forEach(Consumer<T> consumer) { data.forEach(consumer); }
}

public class StreamProcessingEngine {
    public static void main(String[] args) {
        // Problem 12: Implement stream processing engine.
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Define the transformation function
        Function<String, Integer> nameLengthMapper = String::length;

        DataStream.of(names)
                  .map(nameLengthMapper)
                  .forEach(System.out::println);
    }
}

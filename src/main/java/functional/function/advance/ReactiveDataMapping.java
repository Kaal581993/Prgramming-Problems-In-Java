package functional.function.advance;

import java.util.function.Consumer;
import java.util.function.Function;

// An Observable that can transform its data using a mapping function.
class Observable<T> {
    private Consumer<T> subscriber;

    public void subscribe(Consumer<T> subscriber) {
        this.subscriber = subscriber;
    }

    public <R> Observable<R> map(Function<T, R> mapper) {
        Observable<R> newObservable = new Observable<>();
        // When the original observable gets data, it will apply the mapper
        // and pass the transformed data to the new observable's subscriber.
        this.subscribe(data -> newObservable.emit(mapper.apply(data)));
        return newObservable;
    }

    public void emit(T data) {
        if (subscriber != null) {
            subscriber.accept(data);
        }
    }
}

public class ReactiveDataMapping {
    public static void main(String[] args) {
        // Problem 14: Implement reactive data mapping.
        Observable<Integer> numberStream = new Observable<>();

        // Define a mapping function from Integer to String
        Function<Integer, String> intToString = n -> "Number: " + n;

        // The final consumer that prints the transformed data
        Consumer<String> finalSubscriber = System.out::println;

        // Create a new stream by mapping the original one, and subscribe to it.
        numberStream.map(intToString).subscribe(finalSubscriber);

        // Emit data from the original source stream
        System.out.println("Emitting data...");
        numberStream.emit(10);
        numberStream.emit(20);
    }
}

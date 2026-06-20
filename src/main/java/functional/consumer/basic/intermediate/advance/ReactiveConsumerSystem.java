package functional.consumer.basic.intermediate.advance;

import java.util.function.Consumer;

// A simple "Observable" that emits data
class Observable<T> {
    private Consumer<T> onNext;
    private Consumer<Throwable> onError;
    private Runnable onComplete;

    public void subscribe(Consumer<T> onNext, Consumer<Throwable> onError, Runnable onComplete) {
        this.onNext = onNext;
        this.onError = onError;
        this.onComplete = onComplete;
    }

    public void emit(T data) {
        if (onNext != null) {
            onNext.accept(data);
        }
    }

    public void error(Throwable err) {
        if (onError != null) {
            onError.accept(err);
        }
    }

    public void complete() {
        if (onComplete != null) {
            onComplete.run();
        }
    }
}

public class ReactiveConsumerSystem {
    public static void main(String[] args) {
        // Problem 15: Implement reactive consumer system.
        Observable<String> dataStream = new Observable<>();

        // Define the three consumers for the reactive stream
        Consumer<String> onNextConsumer = data -> System.out.println("DATA RECEIVED: " + data);
        Consumer<Throwable> onErrorConsumer = error -> System.err.println("ERROR: " + error.getMessage());
        Runnable onCompleteConsumer = () -> System.out.println("Stream complete.");

        // Subscribe the consumers to the stream
        dataStream.subscribe(onNextConsumer, onErrorConsumer, onCompleteConsumer);

        // Simulate emitting data and events
        dataStream.emit("First Data");
        dataStream.emit("Second Data");
        dataStream.error(new RuntimeException("Something went wrong!"));
        dataStream.emit("Third Data (will not be processed after error)");
        dataStream.complete();
    }
}

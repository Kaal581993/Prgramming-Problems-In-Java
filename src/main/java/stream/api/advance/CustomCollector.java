package stream.api.advance;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

// A custom collector to calculate the weighted average of numbers.
class WeightedAverageCollector implements Collector<Integer, double[], Double> {
    @Override
    public Supplier<double[]> supplier() {
        // The container: { sum, weight }
        return () -> new double[2];
    }

    @Override
    public BiConsumer<double[], Integer> accumulator() {
        // How to add an element to the container.
        return (a, n) -> {
            a[0] += n; // sum
            a[1] += 1; // weight
        };
    }

    @Override
    public BinaryOperator<double[]> combiner() {
        // How to merge two containers in parallel processing.
        return (a1, a2) -> {
            a1[0] += a2[0];
            a1[1] += a2[1];
            return a1;
        };
    }

    @Override
    public Function<double[], Double> finisher() {
        // How to produce the final result from the container.
        return a -> (a[1] == 0) ? 0.0 : a[0] / a[1];
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}

public class CustomCollector {
    public static void main(String[] args) {
        // Problem 14: Build custom collector.
        Stream<Integer> numbers = Stream.of(10, 20, 30, 40, 50);

        double average = numbers.collect(new WeightedAverageCollector());

        System.out.println("The average is: " + average);
    }
}

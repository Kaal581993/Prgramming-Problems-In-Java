package functional.function.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DynamicTransformationPipeline<T> {
    private final List<Function<T, T>> transformations = new ArrayList<>();

    public void addStep(Function<T, T> step) {
        transformations.add(step);
    }

    public T process(T initialValue) {
        // Chain all the functions together using andThen
        Function<T, T> pipeline = transformations.stream()
                .reduce(Function.identity(), Function::andThen);
        
        return pipeline.apply(initialValue);
    }

    public static void main(String[] args) {
        // Problem 13: Create dynamic transformation pipeline.
        DynamicTransformationPipeline<String> pipeline = new DynamicTransformationPipeline<>();

        // Add transformation steps dynamically
        pipeline.addStep(String::trim);
        pipeline.addStep(String::toUpperCase);
        pipeline.addStep(s -> "[PROCESSED] " + s);

        String input = "  some messy data  ";
        String result = pipeline.process(input);

        System.out.println("Original: '" + input + "'");
        System.out.println("Result: '" + result + "'");
    }
}

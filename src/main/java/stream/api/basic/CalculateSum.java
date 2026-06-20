package stream.api.basic;

import java.util.List;

public class CalculateSum {
    public static void main(String[] args) {
        // Problem 4: Calculate sum using reduce().
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // The reduce operation combines elements of a stream into a single result.
        // The first argument (0) is the identity, the second is the accumulator function.
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        
        // A method reference can also be used: .reduce(0, Integer::sum);

        System.out.println("The sum of the list is: " + sum);
    }
}

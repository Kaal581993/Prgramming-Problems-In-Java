package coding.problems.easy.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMissingNumber {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 5};
        int n = arr.length + 1; // n=5

// Expected sum of 1 to n: n*(n+1)/2
        int expectedSum = n * (n + 1) / 2; // 4x(4+1)/2  =

        System.out.println("The expectedSum is: "+expectedSum);

// Actual sum using streams
        int actualSum = Arrays.stream(arr).sum();

        System.out.println("The actualSum is: "+actualSum);


// Missing number
        int missing = expectedSum - actualSum;

        System.out.println("The missing is: "+missing);


// approach 2:

        int missing2 =
                IntStream
                .rangeClosed(1, n)
                .filter(i -> IntStream.of(arr)
                        .noneMatch(x -> x == i))
                .findFirst()
                .orElse(-1);

        System.out.println("The missing value in an Array: "+missing2);

// Approach 3:
        Set<Integer> expected =
                IntStream
                .rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toSet());
        System.out.println("The expected value is"+expected);


        Set<Integer> actual =
                Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toSet());

        System.out.println("The actual value is"+actual);
        expected.removeAll(actual);

        System.out.println("After removal of actual value in expected"+expected);



        // approach 3

        int missing3 = expected.iterator().next();

//        List<Integer> numList = new ArrayList<>(List.of(
//                1,2,3,5
//        ));

    }
}

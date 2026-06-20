package geeks_for_geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MaxSubArraySum {

    /**
     *
     * You are given an integer array arr[]. You need to find the maximum sum of a subarray (containing at least one element) in the array arr[].
     *
     * Note : A subarray is a continuous part of an array.
     *
     * Examples:
     *
     * Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
     * Output: 11
     * Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.
     * Input: arr[] = [-2, -4]
     * Output: -2
     * Explanation: The subarray [-2] has the largest sum -2.
     * Input: arr[] = [5, 4, 1, 7, 8]
     * Output: 25
     * Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.
     * Constraints:
     * 1 ≤ arr.size() ≤ 105
     * -104 ≤ arr[i] ≤ 104
     * */

    static class State {
        int current;
        int max;

        State(int current, int max) {
            this.current = current;
            this.max = max;
        }
    }
    int maxSubarraySum(int[] arr) {

        State result = Arrays.stream(arr)
                .skip(1)
                .boxed()
                .reduce(
                        new State(arr[0], arr[0]),
                        (state, value) -> {

                            int current =
                                    Math.max(value,
                                            state.current + value);

                            int max =
                                    Math.max(state.max,
                                            current);

                            return new State(current, max);
                        },
                        (a, b) -> a
                );

        return result.max;
    }
}
class Solution {
    int maxSubarraySum(int[] arr) {

        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            currentSum = Math.max(arr[i],
                    currentSum + arr[i]);

            maxSum = Math.max(maxSum,
                    currentSum);
        }

        return maxSum;
    }
}
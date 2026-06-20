package geeks_for_geeks;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.
 *
 * Note: If no such array is possible then, return [-1].
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 3, 7, 5], target = 12
 * Output: [2, 4]
 *
 * Explanation: The sum of elements from 2nd to 4th position is 12.
 *
 *
 * Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
 * Output: [1, 5]
 * Explanation: The sum of elements from 1st to 5th position is 15.
 * Input: arr[] = [5, 3, 4], target = 2
 * Output: [-1]
 * Explanation: There is no subarray with sum 2.
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 0 ≤ arr[i] ≤ 103
 * 0 ≤ target ≤ 109
 * */



public class IndexOfSubarraySum {

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();

        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < arr.length; end++) {
            // Expand the window by adding the current element
            currentSum += arr[end];

            // Shrink the window from the left if the sum exceeds the target
            while (currentSum > target && start < end) {
                currentSum -= arr[start];
                start++;
            }

            // Check if we have found our target subarray
            if (currentSum == target) {
                result.add(start + 1); // 1-based start index
                result.add(end + 1);   // 1-based end index
                return result;
            }
        }
        // If no subarray is found, return [-1]
        result.add(-1);
        return result;
    }

    static ArrayList<Integer> subarraySumOptimized(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int currentSum = 0;
        for (int end = 0; end < arr.length; end++) {
            // Optimization 1: If current element alone is greater than target,
            // no subarray containing it can sum to target. Skip it entirely.
            if (arr[end] > target) {
                start = end + 1;
                currentSum = 0;
                continue;
            }
            // Expand the window
            currentSum += arr[end];
            // Optimization 2: Since arr[end] <= target, currentSum is guaranteed
            // to become <= target before start exceeds end.
            // We can safely remove the 'start < end' check from the loop condition.
            while (currentSum > target) {
                currentSum -= arr[start];
                start++;
            }
            // Check if we found the target
            if (currentSum == target) {
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }
        }
        result.add(-1);
        return result;
    }

    private static class WindowState {
        int start = 0;
        int currentSum = 0;
        int foundStart = -1;
        int foundEnd = -1;
    }
    static ArrayList<Integer> subarraySumStreams(int[] arr, int target) {
        WindowState state = new WindowState();
        // Stream over the array indices representing the 'end' pointer
        boolean found = IntStream.range(0, arr.length)
                .filter(end -> {
                    // Expand window
                    state.currentSum += arr[end];
                    // Shrink window if sum is too large
                    while (state.currentSum > target && state.start < end) {
                        state.currentSum -= arr[state.start];
                        state.start++;
                    }
                    // If target is met, record coordinates and return true
                    if (state.currentSum == target) {
                        state.foundStart = state.start;
                        state.foundEnd = end;
                        return true;
                    }
                    return false;
                })
                .findFirst() // Short-circuit: stops execution as soon as the first match is found
                .isPresent();
        if (found) {
            return new ArrayList<>(Arrays.asList(state.foundStart + 1, state.foundEnd + 1));
        } else {
            return new ArrayList<>(Arrays.asList(-1));
        }
    }


}

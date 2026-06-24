package patterns.traversal.list.two_pointer_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseArrayInPlace {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};

        int left =0;
        int right=arr.length-1;

        while (left<right){

            // Swap using a temporary variable
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;

        }

        List<Integer> arrayList = new ArrayList<Integer>();
        for(int num:arr){
            System.out.println(num);

            arrayList.add(num);
        }



        //Method 1: Using IntStream.range() for Reverse Traversal

// Steps:
// 1. Create a range from last index to 0 (inclusive)
// 2. Use forEach to access elements in reverse order
        IntStream.range(arr.length - 1, -1)
                .forEach(i -> System.out.print(arr[i] + " "));


        //Method 2: Using IntStream.iterate() for Reverse Traversal


// Steps:
// 1. Start from last index
// 2. Define condition: continue while i >= 0
// 3. Decrement: i -> i - 1
// 4. Use forEach to print elements
        IntStream.iterate(arr.length - 1, i -> i >= 0, i -> i - 1)
                .forEach(i -> System.out.print(arr[i] + " "));



        //Method 3: Create New Reversed Array (Not In-Place)


// Steps:
// 1. Create range from 0 to length
// 2. Map each index to its mirror position: arr.length - 1 - i
// 3. Collect to new array
        int[] reversed = IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - 1 - i])
                .toArray();

        //Method 4: Using IntStream.rangeClosed()
// Steps:
// 1. Use rangeClosed(1, arr.length) to get 1,2,3,4,5
// 2. Map to zero-based index: arr.length - i
// 3. Use forEach to print
        IntStream.rangeClosed(1, arr.length)
                .map(i -> arr.length - i)
                .forEach(i -> System.out.print(arr[i] + " "));


        /**
         *
         * Two-Pointer Logic vs Stream-Based Reverse
         * The Key Difference
         * True Two-Pointer (In-Place Swap) - what's in ReverseArrayInPlace.java:
         *
         * Uses two indices that move toward each other
         * Swaps elements at those positions
         * Modifies the original array
         * O(1) space complexity
         * Stream-Based Methods - what's in ReverseArrayWithStreams.java:
         *
         * Uses stream iteration to traverse indices in reverse order
         * No swapping - just reads elements in reverse order
         * Either prints or creates a new array
         * O(n) space complexity (creates new array)
         * Why Streams Don't Have True Two-Pointer Logic
         * Streams are functional and immutable by design. They process elements in a pipeline but don't support:
         *
         * In-place modification
         * Simultaneous access to two positions
         * Swapping values
         * The Closest Stream Equivalent to Two-Pointer
         * If you wanted to simulate two-pointer logic with streams, you'd need to:
         * */

        // This is NOT true two-pointer, but shows the concept
        int[] arr3 = {10, 20, 30, 40, 50};

// Get pairs of indices that would be swapped
        IntStream.range(0, arr3.length / 2)
                .forEach(i -> {
                    int leftIndex = i;
                    int rightIndex = arr3.length - 1 - i;
                    System.out.println("Swap positions: " + leftIndex + " and " + rightIndex);
                    // But you can't actually swap in a stream!
                });


// Step 1: Initialize ArrayList
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));

// Step 2: Initialize two pointers
        int left1 = 0;
        int right1 = list.size() - 1;

// Step 3: Swap in a loop
        while (left1 < right1) {
            // Get values
            int leftVal = list.get(left1);
            int rightVal = list.get(right1);

            // Swap using set()
            list.set(left1, rightVal);
            list.set(right1, leftVal);

            // Move pointers
            left++;
            right--;
        }


    }
}

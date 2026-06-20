package patterns.traversal;


/**
 *
 * Used in:
 *
 * Subarray Problems
 * Maximum Sum Window
 *
 * */

public class SlidingWindowTraversal {

    public static void slidingWindowTraversal(int arr[]){
        int k = 3;

        for (int i = 0;
             i <= arr.length - k;
             i++) {

            int sum = 0;

            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }

            System.out.println(sum);
        }
    }
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        slidingWindowTraversal(arr);
    }
}

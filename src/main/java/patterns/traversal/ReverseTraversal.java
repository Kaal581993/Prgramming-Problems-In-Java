package patterns.traversal;

public class ReverseTraversal {
/**
 * Used in:
 *
 * Reverse operations
 * Two Pointer problems
 *
 * */

    public static void reverseTraversal(int arr[]){
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        reverseTraversal(arr);
    }
}

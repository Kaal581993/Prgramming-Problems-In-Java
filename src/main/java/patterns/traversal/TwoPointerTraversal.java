package patterns.traversal;


/**
 *
 * Used in:
 *
 * Pair Sum
 * Palindrome
 * Reverse Array
 * */
public class TwoPointerTraversal {
    public static void twoPointerTraversal(int arr[]){
        int left = 0;
        int right = arr.length - 1;

        while (left < right|| left ==right) {
            System.out.println(arr[left] + " " + arr[right]);

            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        int[] arr2 = {100, 90, 70, 60, 50};

        twoPointerTraversal(arr);
        twoPointerTraversal(arr2);
    }
}

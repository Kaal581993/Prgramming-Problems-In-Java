package patterns.traversal.list.two_pointer_traversal;

public class CheckPalindromeEfficiently {

    public static boolean isPalindrome(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false; // Mismatch found, not a palindrome
            }
            left++;
            right--;
        }

        return true; // All pairs matched
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,4,3,2,1};

        System.out.println("Is palindrome: " + isPalindrome(arr));

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Is palindrome: " + isPalindrome(arr2));

    }
}

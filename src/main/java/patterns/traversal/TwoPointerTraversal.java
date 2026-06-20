package patterns.traversal;

public class TwoPointerTraversal {
    public static void twoPointerTraversal(int arr[]){
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            System.out.println(arr[left] + " " + arr[right]);

            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        twoPointerTraversal(arr);
    }
}

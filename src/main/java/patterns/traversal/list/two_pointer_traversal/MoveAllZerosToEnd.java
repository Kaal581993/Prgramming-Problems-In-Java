package patterns.traversal.list.two_pointer_traversal;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 4,0, 1, 7,0, 3, 12};

        int slow = 0;
        int fast = 0;

        // 2-pointer traversal:
        // slow tracks position for next non-zero,
        // fast scans the array
        while (fast < arr.length) {
            if (arr[fast] != 0) {
                // Swap elements at slow and fast positions
                int temp = arr[slow];
                arr[slow] = arr[fast];
                arr[fast] = temp;

                slow++;
            }
            fast++;
        }

        // Print the result
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

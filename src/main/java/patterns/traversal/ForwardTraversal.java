package patterns.traversal;

public class ForwardTraversal {


    /**
     *
     * Used in:
     *
     * Searching
     * Counting
     * Summation
     * Maximum/Minimum
     *
     * */

    public static void forwardTraversal(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void forwardTraversalEnhancedForEach(int[] arr){
        for(int num: arr){
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        forwardTraversal(arr);
        System.out.println();
        forwardTraversalEnhancedForEach(arr);
    }
}

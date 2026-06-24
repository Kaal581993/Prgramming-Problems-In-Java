package patterns.traversal.list.two_pointer_traversal;

public class PairSumEqualsTarget {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};

        int target=8;

        int left=0;
        int right=arr.length-1;

        while(left <= right){

            int sum=arr[left]+arr[right];
            if (sum == target) {
                System.out.println("(" + arr[left] + "," + arr[right] + ")");
                left++;
                right--;
            } else if (sum < target) {
                left++;  // Need larger sum
            } else {
                right--; // Need smaller sum
            }


        }
    }
}

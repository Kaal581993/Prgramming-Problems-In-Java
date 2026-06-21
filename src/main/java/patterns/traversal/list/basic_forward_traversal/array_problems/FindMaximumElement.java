package patterns.traversal.list.basic_forward_traversal.array_problems;

import java.util.Arrays;

public class FindMaximumElement {
    public static void main(String[] args) {
        int[] arr={5,20,8,12};

        System.out.println("The Maximum number in the following arrey: "
                + Arrays.toString(arr) +"\n"
            + Arrays.stream(arr).max().toString());

        System.out.println("Without using Streams");

        int maxNum=0;
        for(int i=0; i<arr.length; i++){
            if(maxNum<arr[i]){
                maxNum=arr[i];
            }
        }
        System.out.println("The Maximum number is:" + maxNum);
    }
}

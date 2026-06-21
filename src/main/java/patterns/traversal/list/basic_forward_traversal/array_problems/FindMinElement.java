package patterns.traversal.list.basic_forward_traversal.array_problems;

import java.util.Arrays;

public class FindMinElement {

    public static void main(String[] args) {
        int[] arr={5,20,8,12};

        System.out.println("The Maximum number in the following arrey: "
                + Arrays.toString(arr) +"\n"
                + Arrays.stream(arr).min());

        System.out.println("Without using Streams");

        int minNum=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(minNum>arr[i]){
                minNum=arr[i];
            }
        }
        System.out.println("The Minium number is:" + minNum);
    }
}

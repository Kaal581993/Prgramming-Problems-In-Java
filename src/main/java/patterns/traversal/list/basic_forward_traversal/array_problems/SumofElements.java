package patterns.traversal.list.basic_forward_traversal.array_problems;

import java.util.Arrays;

public class SumofElements {
/**
 * Concept:
 *
 * Running accumulator
 * */
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20};

        int sum = 0;


        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("The sum of elements in array: " + Arrays.toString(arr)  + " is: " + sum);


        System.out.println("Sum with enhanced Foreach Loop:");
        int sum2=0;
        for(int num: arr){
            sum2 += num;
        }

        System.out.println(sum2);

        System.out.println("Sum with Stream:");

        int sumWithStream = Arrays.stream(arr).sum();
        System.out.println(sumWithStream);
    }
}

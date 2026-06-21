package patterns.traversal.list.basic_forward_traversal.array_problems;

import java.util.Arrays;
import java.util.function.Consumer;

public class CountEvenNumbers {
/**
 * Concept:
 *
 * Traversal + condition
 * */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int count=0;
        for(int num: arr){
            if(num%2==0){
                count++;
            }
        }

        System.out.println("The total even number count is: "+count);

        System.out.println("By using Streams");


        System.out.println(Arrays.stream(arr).filter(i->i%2==0).count());
    }
}

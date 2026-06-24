package patterns.traversal.list.reverse_traversal;

import java.util.*;
import java.util.stream.IntStream;

public class ReverseCopy {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<Integer>(
                List.of(1,2,3,4,5,6)
        );

        List<Integer> reverseList = arrayList.reversed();

        System.out.println("The reversal of ArrayList");
        System.out.println("The reversed List is:"+ reverseList);

        System.out.println("-----The array reversal -----");

        int[] arr={1,2,3,4,5,6};


        for(int i=arr.length-1; i>=0;i--){
            System.out.println(arr[i]);
        }


//        // Method 1: Using IntStream.range to traverse in reverse
//        System.out.println("\nMethod 1: IntStream.range for reverse traversal:");
//         IntStream
//                .rangeClosed(arr.length - 1, 0)
//                .forEach(i -> System.out.print(arr[i] + " "));
//        System.out.println(output);
        //This didn't worked



        // Method 2: Using IntStream.iterate for reverse traversal
        System.out.println("\nMethod 2: IntStream.iterate for reverse traversal:");
        IntStream
                .iterate(arr.length - 1, i -> i >= 0, i -> i - 1)
                .forEach(i -> System.out.print(arr[i] + " "));
        System.out.println();

        // Method 3: Create reversed array using streams
        System.out.println("\nMethod 3: Create reversed array using streams:");
        int[] reversed = IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - 1 - i])
                .toArray();
        System.out.println("Reversed array: " + Arrays.toString(reversed));

        // Method 4: Using IntStream.rangeClosed
        System.out.println("\nMethod 4: IntStream.rangeClosed for reverse traversal:");
        IntStream.rangeClosed(1, arr.length)
                .map(i -> arr.length - i)
                .forEach(i -> System.out.print(arr[i] + " "));
        System.out.println();

       // System.out.println("Array reversal using streams"+Arrays.toString(arr));
    }
}

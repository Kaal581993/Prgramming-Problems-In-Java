package patterns.traversal.interview_level.reverse_traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PrintArrayInReverse {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};

        int[] reverseArr = new int[arr.length];

        for(int i=arr.length-1; i>=0;i--){
            reverseArr[i]=arr[i];

            System.out.println(reverseArr[i]);
        }

        List<Integer> arrayList= new ArrayList<>(
                List.of(1,2,3,4,5)
        );

        arrayList.reversed();

        System.out.println(arrayList.toString());

        IntStream.range(arr.length-1,-1)
                .forEach(i-> System.out.println(" "+arr[i]));

        System.out.println();

        IntStream.iterate(arr.length-1,i->i>=0,i->i-1)
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
    }
}

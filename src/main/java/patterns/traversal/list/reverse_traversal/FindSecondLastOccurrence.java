package patterns.traversal.list.reverse_traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindSecondLastOccurrence {

    public static void main(String[] args) {
       int[] arr = {5,6,7,5,7,5,8,5};
       int target = 5;

       List<Integer> targetArray = new ArrayList<Integer>();
       int count=0;

       //Print the index of 2nd last occurence of element in array

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==target){
                count++; // increment of the count
                if(count==2){
                    System.out.println("The index of second last occurence \n"+i);
                }
                targetArray.add(i);
            }

        }

       // System.out.println(targetArray);
        targetArray.remove(0);

        System.out.println(targetArray.get(0));


        //using streams

        int result = IntStream.iterate(arr.length - 1, i -> i >= 0, i -> i - 1)
                .filter(i -> arr[i] == target)
                // Filter indices where value matches target
                .skip(1)
                // Skip the first match (last occurrence)
                .findFirst()
                // Get the second match
                .orElse(-1);


        System.out.println(result);

        int[] indices = IntStream.iterate(arr.length - 1, i -> i >= 0, i -> i - 1)
                .filter(i -> arr[i] == target)
                .limit(2)
                .toArray();

        //System.out.println(Arrays.stream(indices).toArray());
        int result2 = indices.length == 2 ? indices[1] : -1;

        System.out.println(result2);

        List<Integer> indices2 = IntStream.iterate(arr.length - 1, i -> i >= 0, i -> i - 1)
                .filter(i -> arr[i] == target)
                .limit(2)
                .boxed()
                .collect(Collectors.toList());

        int result3 = indices2.size() == 2 ? indices2.get(1) : -1;
        System.out.println(indices2.toString()  +","+result3);


    }
}

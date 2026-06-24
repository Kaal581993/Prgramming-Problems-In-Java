package patterns.traversal.interview_level;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunningSum {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};

        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i];
        }

        for (int num:arr){
            System.out.println(num);
        }

        List<Integer> arrayList = new ArrayList<Integer>(
                List.of(1,2,3,4,5,6,7)
        );

        // Using ArrayList get() and set() methods
        for (int i = 1; i < arrayList.size(); i++) {
            arrayList.set(i, arrayList.get(i - 1) + arrayList.get(i));
        }

        System.out.println();
        // Print result
        arrayList.forEach(System.out::println);

        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> runningSum = arrayList.stream()
                .map(num -> sum.addAndGet(num))
                .collect(Collectors.toList());

        /**
         *
         * Key Stream concepts:
         *
         * AtomicInteger - thread-safe integer that allows mutation in streams
         * addAndGet(int delta) - atomically adds and returns the new value
         * map() - transforms each element
         * collect(Collectors.toList()) - collects results into a List
         *
         * */

        System.out.println();
        runningSum.forEach(System.out::println);

//Solution 3: Using IntStream (Array-based)



        int[] runningSum2 = IntStream.range(0, arr.length)
                .map(i -> {
                    if (i == 0) return arr[0];
                    return arr[i] + arr[i - 1];
                    // This won't work as expected - see note below
                    //The above IntStream approach has a
                    // limitation - it doesn't modify the
                    // original array. For a proper running
                    // sum with IntStream, you'd need to use a
                    // mutable approach
                })
                .toArray();

        System.out.println();
        for(int num: runningSum2){
            System.out.println(num);
        }

    }
}

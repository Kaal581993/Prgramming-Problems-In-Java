package patterns.traversal.interview_level;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FindEquilibriumIndex {
    public static void main(String[] args) {
        int[] arr={1,3,5,2,2};

        int left=0;
        int right=arr.length-1;

        int leftSum=0;


        int totalSum=0;

        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }

        System.out.println("total sum: "+totalSum);
        int rightSum=totalSum;


        for(int i=0;i<arr.length;i++){
            rightSum=rightSum-arr[i];
            if(leftSum==rightSum){
                System.out.println(i);
            }
            leftSum = leftSum + arr[i];
        }

        //Using ArrayList with Streams
        List<Integer> arrayList = new ArrayList<Integer>(
                List.of(1,3,5,2,2)
        );

        // Calculate total sum using streams
        int totalUsingStreams = arrayList.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Total sum (streams): " + totalUsingStreams);

        // Find equilibrium index using streams with AtomicInteger for index tracking
        AtomicInteger leftSumStream = new AtomicInteger(0);
        AtomicInteger rightSumStream = new AtomicInteger(totalUsingStreams);

        for (int i = 0; i < arrayList.size(); i++) {
            rightSumStream.addAndGet(-arrayList.get(i));
            if (leftSumStream.get() == rightSumStream.get()) {
                System.out.println("Equilibrium index (ArrayList/Streams): " + i);
            }
            leftSumStream.addAndGet(arrayList.get(i));
        }
    }
}

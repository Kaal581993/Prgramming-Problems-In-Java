package patterns.traversal.interview_level;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountPositiveandNegativeNumbers {
    public static void main(String[] args) {
        int [] arr = {-1,2,-3,4,5,-6};

        int negativeCounter=0;
        int positiveCounter=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                negativeCounter++;
            }else if(arr[i]>=0){
                positiveCounter++;
            }
        }

        System.out.println("The positive Counter: "+positiveCounter
        +"\n The negative Counter: "+negativeCounter);


        //Using the Arraylist

        List<Integer> arrayList = new ArrayList<>(
                List.of(-1,2,-3,4,5,-6)
        );

        negativeCounter=0;
        positiveCounter=0;
        for(int num: arrayList){
            if(num<0){
                negativeCounter++;
            }else if(num>=0){
                positiveCounter++;
            }
        }

        System.out.println("The positive Counter: "+positiveCounter
                +"\n The negative Counter: "+negativeCounter);


// Count negative numbers
        long negativeCount = arrayList.stream()
                .filter(i -> i < 0)
                .count();

// Count positive numbers (including zero)
        long positiveCount = arrayList.stream()
                .filter(i -> i >= 0)
                .count();

        System.out.println("Positive = " + positiveCount);
        System.out.println("Negative = " + negativeCount);

        long negativeCount2 = IntStream.of(arr)
                .filter(i -> i < 0)
                .count();

        long positiveCount2 = IntStream.of(arr)
                .filter(i -> i >= 0)
                .count();

        System.out.println("Positive = " + positiveCount2);
        System.out.println("Negative = " + negativeCount2);


        // Single pass - more efficient!
        Map<String, Long> counts = arrayList.stream()
                .collect(Collectors.groupingBy(
                        i -> i < 0 ? "Negative" : "Positive",
                        Collectors.counting()
                ));

        System.out.println("Positive = " + counts.getOrDefault("Positive", 0L));
        System.out.println("Negative = " + counts.getOrDefault("Negative", 0L));

    }
}

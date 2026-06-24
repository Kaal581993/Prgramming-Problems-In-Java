package patterns.traversal.interview_level;

import java.util.ArrayList;
import java.util.List;

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



    }
}

package patterns.traversal.list.index_aware_traversal;

import java.util.ArrayList;
import java.util.List;

public class FindLastOccurrence {

    public static void main(String[] args) {
        int[] arr = {10,20,30,20,50};

        List<Integer> arrayList = new ArrayList<>();
        int target=20;

        for(int num: arr){
            //System.out.println(num);
            arrayList.add(num);
        }

        System.out.println("The first occurene of the target value: "
                +target+" is: "+arrayList.lastIndexOf(20));

    }
}

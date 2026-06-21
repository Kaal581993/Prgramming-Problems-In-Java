package patterns.traversal.list.index_aware_traversal;

import java.util.ArrayList;
import java.util.List;

public class CountFrequency {

    public static void main(String[] args) {

        int[] arr = {1,2,1,3,1};
        int target = 1;

        List<Integer> arrayList = new ArrayList<>();


        for(int num: arr){
            //System.out.println(num);
            arrayList.add(num);
        }


        System.out.println(arrayList.stream().filter(i->i==1).count());
    }
}

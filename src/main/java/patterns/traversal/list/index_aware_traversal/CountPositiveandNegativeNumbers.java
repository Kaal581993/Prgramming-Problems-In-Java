package patterns.traversal.list.index_aware_traversal;

import java.util.ArrayList;
import java.util.List;

public class CountPositiveandNegativeNumbers {

    public static void main(String[] args) {
        int[] arr = {-1,2,-3,4,5,-6};

        List<Integer> arrayList = new ArrayList<>();
        for(int num: arr){
            //System.out.println(num);
            arrayList.add(num);
        }

        System.out.println("Negative Numbers ArrayList count: "+arrayList.stream().filter(i->i<0).count());

        System.out.println("Positive Numbers ArrayList count:"+arrayList.stream().filter(i->i>=0).count());
    }
}

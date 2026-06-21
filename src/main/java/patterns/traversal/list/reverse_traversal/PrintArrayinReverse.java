package patterns.traversal.list.reverse_traversal;

import java.util.ArrayList;
import java.util.List;

public class PrintArrayinReverse {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};

        List<Integer> arrayList = new ArrayList<>();

        for(int num: arr){
            arrayList.add(num);
        }

        System.out.println("The reverse ArrayList: "+arrayList.reversed());
    }
}

package patterns.traversal.list.reverse_traversal;

import java.util.ArrayList;
import java.util.List;

public class ChekPalinDromeArray {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<Integer>(List.of(
                1,2,3,4,5,4,3,2,1
        ));

        if(arrayList.reversed().equals(arrayList)){
            System.out.println("The given Array is PalinDrome");
        }

    }
}

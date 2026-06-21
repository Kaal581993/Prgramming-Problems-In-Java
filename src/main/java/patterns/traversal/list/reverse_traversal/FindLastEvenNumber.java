package patterns.traversal.list.reverse_traversal;

import java.util.*;
public class FindLastEvenNumber {
    public static void main(String[] args) {
        int [] arr = {1,3,7,8,5,6};

        List<Integer> arrayList = new ArrayList<>();

        for(int num: arr){
            arrayList.add(num);
        }

        System.out.println("The Last Even Number is: "
                + arrayList.reversed().stream()
                .filter(i->i%2==0)
                .findFirst()
                .orElse(-1));

    }
}

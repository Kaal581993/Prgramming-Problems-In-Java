package coding.problems.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        List numList = new ArrayList(List.of(
                9,8,7,6,5,4,3,2,1
        ));

        System.out.println("\n The Original list:\n"+numList);

        Collections.reverse(numList);

        System.out.println( "\n The reverseList: \n"+numList);
    }
}

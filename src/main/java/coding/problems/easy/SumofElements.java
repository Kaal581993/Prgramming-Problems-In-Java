package coding.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class SumofElements {

    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<>(
                List.of(2,4,5,8,10,20,17,38)
        );

        int sumOfElements = numList.stream().mapToInt(n->n).sum();

        System.out.println(sumOfElements);

    }
}

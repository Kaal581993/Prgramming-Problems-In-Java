package coding.problems.easy;

import java.util.*;

public class FindMaxElement {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>(List.of(4,8,1,10));
           int maxElement = num.stream().mapToInt(Integer::intValue).max().orElse(-1);
        System.out.println(maxElement);

        //Using Collection.max

        System.out.println("\nBy using collection\n");

        int maxElementusingCollection = Collections.max(num);

        System.out.println(maxElementusingCollection);
    }
}

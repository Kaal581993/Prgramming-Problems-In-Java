package coding.problems.easy.intermediate.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddPartition {
    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<>(List.of(
                1,2,3,4,5,6,7
        ));

        List<Integer> evenList = numList
                .stream()
                .filter(i -> i % 2==0)
                .collect(Collectors.toList());

        System.out.println("The Even List is: "+evenList);

        List<Integer> oddList = numList
                .stream()
                .filter(i -> i % 2!=0)
                .collect(Collectors.toList());

        System.out.println("The Odd List is: "+oddList);

        // by using partition by

        System.out.println("\nBy using Streams Partitioned by:\n");
        // Using partitioningBy() - single stream operation
        Map<Boolean, List<Integer>> partitioned = numList.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        List<Integer> evenList2 = partitioned.get(true);
        List<Integer> oddList2 = partitioned.get(false);

        System.out.println("Even = " + evenList2);
        System.out.println("Odd = " + oddList2);

    }
}

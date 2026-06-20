package coding.problems.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(
                1,2,2,3,4,4
        ));

        System.out.println("List of Integers"+ numbers);
        Set uniqueNumbers = new HashSet();

        for(int num: numbers){
            uniqueNumbers.add(num);
        }

        System.out.println("The unique Number List"+uniqueNumbers);

        System.out.println("\n Solution using streams\n");

        List<Integer> result = numbers.stream().distinct().collect(
                Collectors.toList()
        );

        System.out.println(result);
    }
}

package coding.problems.easy.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumberChecker {
    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<>(
                List.of(4,8,9,0,3,5,13,17,19)
        );



        numList.forEach(i ->
                System.out.println(
                        "Is"+i+" odd: " + (i % 2 != 0)
                ));


        // Storing in the Boolean List

        System.out.println("\nStoring in the Boolean List\n");

        List<Boolean> primeList = numList.stream()
                .map(i ->i % 2 !=0)
                .collect(Collectors.toList());

        for (int i=0; i< primeList.size(); i++){
            System.out.println(
                    "Is "+numList.get(i)+" Odd "+primeList.get(i)
            );
        }
    }
}

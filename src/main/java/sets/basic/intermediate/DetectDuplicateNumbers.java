package sets.basic.intermediate;

import java.util.HashSet;
import java.util.Set;

public class DetectDuplicateNumbers {
    public static void main(String[] args) {
        // Problem 8: Detect duplicate numbers.
        int[] numbers = {1, 2, 3, 4, 5, 2, 6, 7, 3};
        System.out.print("Numbers: ");
        for(int num : numbers) System.out.print(num + " ");
        System.out.println();

        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> duplicateNumbers = new HashSet<>();

        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                // .add() returns false if the element is already in the set
                duplicateNumbers.add(number);
            }
        }

        if (!duplicateNumbers.isEmpty()) {
            System.out.println("Duplicate numbers found: " + duplicateNumbers);
        } else {
            System.out.println("No duplicate numbers were found.");
        }
    }
}

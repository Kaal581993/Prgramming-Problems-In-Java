package list.basic;

import java.util.ArrayList;
import java.util.List;

public class RemoveEvenNumbers {

    /**
     *  // Problem 5: Remove all even numbers.
     * */
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("Original list: " + numbers);


        numbers.removeIf(n -> n % 2 == 0);

        System.out.println("List after removing even numbers: " + numbers);
    }
}

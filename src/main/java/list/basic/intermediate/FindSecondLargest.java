package list.basic.intermediate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class FindSecondLargest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);
        numbers.add(20);

        for(int i: numbers){

        }

        System.out.println("Original list: " + numbers);

        // Problem 10: Find second largest element.
        TreeSet<Integer> sortedSet = new TreeSet<>(numbers);
        if (sortedSet.size() < 2) {
            System.out.println("Not enough elements to find the second largest.");
        } else {
            sortedSet.pollLast(); // Remove the largest element
            System.out.println("The second largest element is: " + sortedSet.last());
        }
    }
}

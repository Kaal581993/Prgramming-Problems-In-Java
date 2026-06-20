package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTraversal {
    /**
     * Problem 2
     *
     * Traverse an ArrayList using:
     *
     * Iterator
     * for-each loop
     * Lambda forEach()
     * */

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        // --- 1. Using an Iterator ---
        System.out.println("Traversing with Iterator:");
        // Get the iterator from the ArrayList itself.
        Iterator<Integer> iterator = numbers.iterator();
        // Loop while there are more elements.
        while (iterator.hasNext()) {
            // Get the next element and print it.
            System.out.println(iterator.next());
        }
        System.out.println(); // For spacing

        // --- 2. Using an enhanced for-each loop ---
        System.out.println("Traversing with for-each loop:");
        // This part was already correct.
        for (Integer number : numbers) {
            System.out.println(number);
        }
        System.out.println(); // For spacing

        // --- 3. Using the forEach() method with a lambda ---
        System.out.println("Traversing with forEach() and lambda:");
        // The original code printed the entire 'numbers' list for each element.
        // The correction is to print the 'number' variable from the lambda.
        numbers.forEach(number -> System.out.println(number));
    }
}

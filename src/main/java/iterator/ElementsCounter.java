package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Problem 3
 *
 * Count total elements using Iterator.
 * */
public class ElementsCounter {

    public static void main(String[] args) {
        int count = 0;

        ArrayList<String> elements =
                new ArrayList<>(List.of(
                        "Iron","Copper","Zinc","Magnesium","Potassium", "Manganese"
                ));

        Iterator<String> iterator  = elements.iterator();

        while (iterator.hasNext()){
            iterator.next();
            count++;
        }

        System.out.println("Total elements: " + count);

        // Code Quality Insight:
        // While the above loop correctly solves the problem "using Iterator",
        // the most efficient way to count elements in a collection is to use its size() method.
        // System.out.println("Total elements (efficiently): " + elements.size());
    }
}

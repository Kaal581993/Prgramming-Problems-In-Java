package sets.basic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SortWithTreeSet {
    public static void main(String[] args) {
        // Problem 5: Sort elements using TreeSet.
        Set<String> unsortedSet = new HashSet<>();
        unsortedSet.add("Banana");
        unsortedSet.add("Apple");
        unsortedSet.add("Cherry");
        unsortedSet.add("Date");

        System.out.println("Unsorted Set: " + unsortedSet);

        // A TreeSet automatically stores elements in sorted order
        Set<String> sortedSet = new TreeSet<>(unsortedSet);

        System.out.println("Sorted Set (using TreeSet): " + sortedSet);
    }
}

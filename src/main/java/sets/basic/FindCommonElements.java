package sets.basic;

import java.util.HashSet;
import java.util.Set;

public class FindCommonElements {
    public static void main(String[] args) {
        // Problem 4: Find common elements between two Sets.
        Set<String> set1 = new HashSet<>();
        set1.add("Apple");
        set1.add("Banana");
        set1.add("Cherry");

        Set<String> set2 = new HashSet<>();
        set2.add("Banana");
        set2.add("Date");
        set2.add("Cherry");

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Create a new set to store the common elements
        Set<String> commonElements = new HashSet<>(set1);
        commonElements.retainAll(set2); // Keeps only the elements that are also in set2

        System.out.println("Common elements: " + commonElements);
    }
}

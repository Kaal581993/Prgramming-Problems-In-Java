package functional.bifunction.bipredicate.basic;

import java.util.List;
import java.util.function.BiPredicate;

public class CheckListContainsValue {
    public static void main(String[] args) {
        // Problem 5: Check if list contains value.
        BiPredicate<List<String>, String> listContains = List::contains;

        List<String> names = List.of("Alice", "Bob", "Charlie");

        System.out.println("Does the list contain 'Bob'? " + listContains.test(names, "Bob"));
        System.out.println("Does the list contain 'David'? " + listContains.test(names, "David"));
    }
}

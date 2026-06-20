package list.basic.intermediate;

import java.util.ArrayList;
import java.util.List;

public class MergeLists {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Alice");
        list1.add("Bob");

        List<String> list2 = new ArrayList<>();
        list2.add("Charlie");
        list2.add("David");

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        // Problem 8: Merge two Lists.
        List<String> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);

        System.out.println("Merged list: " + mergedList);
    }
}

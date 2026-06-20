package list.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintElements {

    /**
     * Print all the elements in the list using:
     * *For Loop
     * * Lambda
     * * Iterator
     *
     * */
    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("David");
        studentNames.add("Eve");
        studentNames.add("Frank");
        studentNames.add("Grace");
        studentNames.add("Heidi");
        studentNames.add("Ivan");
        studentNames.add("Judy");

        // Problem 2: Print all elements using for loop, iterator, and lambda.


        System.out.println("Printing with for loop:");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println(studentNames.get(i));
        }

        System.out.println("\nPrinting with iterator:");
        Iterator<String> iterator = studentNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nPrinting with lambda:");
        studentNames.forEach(name -> System.out.println(name));
    }
}

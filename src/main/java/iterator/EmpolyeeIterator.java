package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmpolyeeIterator {
    /**
     * Problem 5
     *
     * Create iterable for employee names.
     *
     * */

    public static void main(String[] args) {

        ArrayList<String> employeenames = new ArrayList<>(
          List.of("Rahul","Abhishek","Shiv","Viral","Daniel")
        );

        Iterator<String> nameIterator = employeenames.iterator();

        while (nameIterator.hasNext()){
            System.out.println(nameIterator.next());
        }

    }
}

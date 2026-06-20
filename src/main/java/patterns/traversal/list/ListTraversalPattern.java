package patterns.traversal.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTraversalPattern {

    public static void main(String[] args) {
        List<String>
                names =
                Arrays.asList("John", "Mike", "David");


        for (String name : names) {
            System.out.println(name);
        }

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }//Used when:  Index required

        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //Used when:Safe removal needed

        ListIterator<String> listIterator =
                names.listIterator();

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        //Reverse Traversal
        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.println(names.get(i));
        }
    }
}

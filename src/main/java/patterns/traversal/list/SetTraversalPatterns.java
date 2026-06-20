package patterns.traversal.list;

import java.util.Iterator;
import java.util.Set;

public class SetTraversalPatterns {
    public static void main(String[] args) {
        Set<Integer> numbers =
                Set.of(10, 20, 30, 40);

        for (Integer num : numbers) {
            System.out.println(num);
        }

        Iterator<Integer> iterator =
                numbers.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //Important:❌ No index
        //numbers.get(0);
        //Not possible.


    }
}

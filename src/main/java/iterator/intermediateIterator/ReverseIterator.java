package iterator.intermediateIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ReverseIterator {
    
    /**
     * Problem 6
     *
     * Create reverse iterator.
     * **/

    // We create a generic, reusable wrapper class that makes any
    // List iterable in reverse.
    // This class implements Iterable, so it can be used in for-each loops.
    public static class ReverseIterable<T> implements Iterable<T> {
        private final List<T> originalList;

        public ReverseIterable(List<T> originalList) {
            this.originalList = originalList;
        }

        @Override
        public Iterator<T> iterator() {
            // We return an anonymous inner class
            // that implements the Iterator interface.
            return new Iterator<T>() {
                // The cursor starts at the end of the list.
                private int cursor = originalList.size();

                /**
                 * Checks if there is a "next" element in our reverse iteration.
                 * This is true as long as the cursor has not reached the beginning.
                 */
                @Override
                public boolean hasNext() {
                    return cursor > 0;
                }

                /**
                 * Returns the next element in the reverse sequence.
                 */
                @Override
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    // Decrement the cursor first, then
                    // get the element at that index.
                    return originalList.get(--cursor);
                }
            };
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(
                List.of(1,2,3,4,5,6,7,8,9,10)
        );

        System.out.println("--- Solution: Using a Custom Reverse Iterator ---");
        // 1. Wrap our list in the ReverseIterable.
        ReverseIterable<Integer> reverseIterable = new ReverseIterable<>(arrayList);

        // 2. Use it in a for-each loop, which works
        // because ReverseIterable implements Iterable.
        System.out.print("For-each loop output: ");
        for (Integer number : reverseIterable) {
            System.out.print(number + " ");
        }
        System.out.println("\n");


        System.out.println("--- Best Practice: Using the Standard Library's ListIterator ---");
        // For lists, the most direct way is to use a ListIterator,
        // which is designed for bidirectional traversal.
        System.out.print("ListIterator output: ");
        // Start the ListIterator at the end of the list.
        ListIterator<Integer> listIterator = arrayList.listIterator(arrayList.size());

        // Use hasPrevious() and previous() to go backward.
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
    }
}

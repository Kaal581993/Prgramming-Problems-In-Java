package iterator.intermediateIterator.advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Problem 12
 *
 * Implement immutable iterator.
 *
 * This class wraps a collection and provides an "immutable" iterator,
 * meaning the iterator cannot be used to modify the collection.
 */
public class ImmutableCollection<T> implements Iterable<T> {

    // The underlying collection that holds the data.
    // It is private to prevent direct modification from outside.
    private final List<T> internalList;

    /**
     * Constructs an ImmutableCollection from a given list of elements.
     * A defensive copy is made to ensure the internal list cannot be changed
     * from the outside after construction.
     */
    public ImmutableCollection(List<T> sourceList) {
        // Create a defensive copy.
        this.internalList = new ArrayList<>(sourceList);
    }

    /**
     * This is the core of the solution. It returns a custom iterator
     * that delegates hasNext() and next() calls but overrides remove()
     * to make it immutable.
     */
    @Override
    public Iterator<T> iterator() {
        // Get the standard iterator from our internal list.
        final Iterator<T> underlyingIterator = internalList.iterator();

        // Return a new anonymous class that wraps the standard iterator.
        // This is an example of the Decorator pattern.
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                // Delegate to the underlying iterator.
                return underlyingIterator.hasNext();
            }

            @Override
            public T next() {
                // Delegate to the underlying iterator.
                return underlyingIterator.next();
            }

            /**
             * This is the key method. By throwing this exception, we are
             * fulfilling the contract of an immutable iterator.
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException("This iterator is immutable; remove() is not supported.");
            }
        };
    }

    @Override
    public String toString() {
        return internalList.toString();
    }

    public static void main(String[] args) {
        // Create a source list.
        List<String> originalData = new ArrayList<>(List.of("Apple", "Banana", "Cherry"));

        // Create our immutable collection wrapper.
        ImmutableCollection<String> immutableList = new ImmutableCollection<>(originalData);

        System.out.println("--- Demonstrating successful read-only iteration ---");
        System.out.println("Initial list: " + immutableList);

        // The for-each loop works perfectly because it only uses hasNext() and next().
        System.out.print("Iterating with for-each loop: ");
        for (String fruit : immutableList) {
            System.out.print(fruit + " ");
        }
        System.out.println("\n");

        System.out.println("--- Demonstrating that remove() is not supported ---");
        // Now, let's get the iterator explicitly and try to call remove().
        Iterator<String> iterator = immutableList.iterator();
        try {
            while (iterator.hasNext()) {
                String fruit = iterator.next();
                if (fruit.equals("Banana")) {
                    System.out.println("Attempting to remove 'Banana'...");
                    iterator.remove(); // This line will throw the exception.
                }
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(">> Successfully caught expected exception: " + e.getMessage());
        }

        // The list remains unchanged.
        System.out.println("Final list is unmodified: " + immutableList);
    }
}
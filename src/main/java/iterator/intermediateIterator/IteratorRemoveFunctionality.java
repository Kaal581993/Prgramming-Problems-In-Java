package iterator.intermediateIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Problem 9
 *
 * Implement iterator with remove functionality.
 */
public class IteratorRemoveFunctionality<T> implements Iterable<T> {

    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public IteratorRemoveFunctionality() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds an element to the end of the list.
     */
    public void add(T element) {
        if (size == elements.length) {
            // Automatically grow the array if it's full.
            elements = Arrays.copyOf(elements, size * 2);
        }
        elements[size++] = element;
    }

    /**
     * A private helper method to remove an element at a specific index.
     * This is the method our iterator will call.
     */
    private void removeElementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int numToShift = size - index - 1;
        if (numToShift > 0) {
            // Shift subsequent elements to the left.
            System.arraycopy(elements, index + 1, elements, index, numToShift);
        }
        // Decrease the size and clear the last element to help the garbage collector.
        elements[--size] = null;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i == size - 1) return sb.append(']').toString();
            sb.append(", ");
        }
        return "[]"; // Should not be reached
    }

    /**
     * Returns an iterator over the elements in this list.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            // 'cursor' points to the index of the next element to be returned.
            private int cursor = 0;
            // 'lastRet' stores the index of the last element returned by next().
            // It is -1 if next() hasn't been called or if remove() was just called.
            private int lastRet = -1;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements to iterate.");
                }
                // Record the index of the element we are about to return.
                lastRet = cursor;
                @SuppressWarnings("unchecked")
                T element = (T) elements[cursor++];
                return element;
            }

            @Override
            public void remove() {
                if (lastRet < 0) {
                    throw new IllegalStateException("next() must be called before remove(), or remove() has already been called since the last call to next().");
                }
                // Use the outer class's private method to remove the element.
                removeElementAt(lastRet);
                // The list has shrunk. The element at the current cursor position has shifted left.
                // To avoid skipping the element that just moved into the 'lastRet' position,
                // we must adjust the cursor back.
                cursor = lastRet;
                // Reset lastRet to -1 to enforce the "one remove() per next()" rule.
                lastRet = -1;
            }
        };
    }

    public static void main(String[] args) {
        IteratorRemoveFunctionality<Integer> numberList = new IteratorRemoveFunctionality<>();
        for (int i = 1; i <= 10; i++) {
            numberList.add(i);
        }

        System.out.println("Original list: " + numberList);

        // Use the iterator to safely remove all even numbers.
        Iterator<Integer> iterator = numberList.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove(); // This is the only safe way to modify a collection while iterating.
            }
        }

        System.out.println("List after removing even numbers: " + numberList);

        // Demonstrate the IllegalStateException by calling remove() again without next().
        try {
            // This will fail because lastRet was reset to -1 by the previous remove().
            iterator.remove();
        } catch (IllegalStateException e) {
            System.out.println("\nSuccessfully caught expected exception: " + e.getMessage());
        }
    }
}

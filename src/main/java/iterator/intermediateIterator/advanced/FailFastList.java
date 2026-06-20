package iterator.intermediateIterator.advanced;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Problem 11
 *
 * Create fail-fast iterator.
 *
 * This class demonstrates a custom list with an iterator that fails fast
 * if the list is modified during iteration from outside the iterator itself.
 */
public class FailFastList<T> implements Iterable<T> {

    private Object[] elements;
    private int size;

    /**
     * This counter is the heart of the fail-fast mechanism.
     * It is incremented every time a structural modification (add/remove) is made to the list.
     * It is marked 'transient' as it's a runtime state, not part of the object's persistent state.
     */
    protected transient int modCount = 0;

    public FailFastList() {
        this.elements = new Object[10];
        this.size = 0;
    }

    /**
     * Adds an element and increments the modification counter.
     */
    public void add(T element) {
        modCount++; // Structural modification
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
        elements[size++] = element;
    }

    /**
     * Removes an element and increments the modification counter.
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        modCount++; // Structural modification
        @SuppressWarnings("unchecked")
        T oldValue = (T) elements[index];
        int numToShift = size - index - 1;
        if (numToShift > 0) {
            System.arraycopy(elements, index + 1, elements, index, numToShift);
        }
        elements[--size] = null; // Clear to let GC do its work
        return oldValue;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    /**
     * Returns our custom fail-fast iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new FailFastIteratorImpl();
    }

    /**
     * The implementation of our fail-fast iterator.
     */
    private class FailFastIteratorImpl implements Iterator<T> {
        private int cursor = 0;
        private int lastRet = -1;

        /**
         * The iterator captures the list's modCount at the moment of its creation.
         * Any mismatch between this and the list's current modCount indicates an external modification.
         */
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastRet = cursor;
            @SuppressWarnings("unchecked")
            T element = (T) elements[cursor++];
            return element;
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException("next() must be called before remove().");
            }
            checkForComodification();

            try {
                // Call the outer class's remove method.
                FailFastList.this.remove(lastRet);
                // The list was modified, so we must update our expected count.
                // This is the ONLY place where the iterator is allowed to "catch up".
                expectedModCount = modCount;
                // Adjust cursor because the list has shrunk.
                cursor = lastRet;
                // Reset lastRet to prevent multiple removes.
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        /**
         * The core check. If the counts don't match, the collection was modified elsewhere.
         */
        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public static void main(String[] args) {
        FailFastList<String> list = new FailFastList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("--- Demonstrating ConcurrentModificationException ---");
        System.out.println("Initial list: " + list);

        try {
            // This loop will fail because we modify the list directly inside it.
            for (String item : list) {
                System.out.println("Iterating over: " + item);
                if (item.equals("B")) {
                    System.out.println(">> Modifying list by adding 'D' while iterating...");
                    list.add("D"); // This modification will be detected by the iterator's next() call.
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(">> Successfully caught expected exception: " + e);
        }

        System.out.println("\n--- Demonstrating safe removal with iterator.remove() ---");
        FailFastList<String> safeList = new FailFastList<>();
        safeList.add("X");
        safeList.add("Y");
        safeList.add("Z");
        System.out.println("Initial safeList: " + safeList);

        Iterator<String> iterator = safeList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("Y")) {
                System.out.println(">> Safely removing 'Y' using iterator.remove()");
                iterator.remove(); // This is the correct way to modify during iteration.
            }
        }
        System.out.println("Final safeList: " + safeList);
    }
}

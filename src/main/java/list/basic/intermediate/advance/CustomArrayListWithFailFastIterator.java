package list.basic.intermediate.advance;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayListWithFailFastIterator<E> implements Iterable<E> {

    // Problem 13: Build fail-fast iterator.
/**
 * This code snippet implements a fail-fast iterator for a custom implementation of an ArrayList.
 * A fail-fast iterator is designed to fail immediately by throwing a ConcurrentModificationException
 * if the underlying collection is structurally modified (e.g., elements added or removed) while the iteration is actively in progress.
 * Here is a detailed breakdown of how the snippet achieves this.
 * */
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elementData;
    private int size = 0;
    private int modCount = 0;
    //modCount (defined in the parent list):
    // A counter tracking structural modifications (such as add operations)
    // made to the list over its entire lifetime.

    public CustomArrayListWithFailFastIterator() {
        this.elementData = new Object[INITIAL_CAPACITY];
    }

    public void add(E e) {
        modCount++;
        if (size == elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = e;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                            "Index: " + index
                            + ", Size: " + size);
        }
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        int newCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public Iterator<E> iterator() {
        return new FailFastIterator();
    }

    private class FailFastIterator implements Iterator<E> {
        private int cursor = 0;
        //cursor: The index of the next element that the iterator will retrieve during traversal, starting at 0.

        private int expectedModCount = modCount;
        //modCount (defined in the parent list): A counter tracking structural modifications
        // (such as add operations) made to the list over its entire lifetime.

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = (E) elementData[cursor];
            cursor++;
            return element;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) {
                System.out.println(modCount + ""+expectedModCount);
                throw new ConcurrentModificationException();
                //This is the core of the fail-fast behavior.
                //If a structural modification has occurred on the parent list, the parent's modCount variable will have incremented.
                //Since the iterator's copy (expectedModCount) remains frozen at its initial creation value,
                // modCount != expectedModCount evaluates to true, triggering a
                // ConcurrentModificationException to prevent unpredictable runtime behavior.
            }
        }
    }

    public static void main(String[] args) {
        CustomArrayListWithFailFastIterator<String> list = new CustomArrayListWithFailFastIterator<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Iterating with fail-fast iterator:");
        try {
            for (String fruit : list) {
                System.out.println(fruit);
                if (fruit.equals("Banana")) {
                    list.add("Date"); // This will cause a ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught expected exception: " + e);
        }
    }
}

package iterator.intermediateIterator.advanced;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Problem 13
 *
 * Build custom collection framework class.
 *
 * This class demonstrates how to build a custom collection by integrating
 * with the Java Collections Framework (JCF). By extending AbstractList,
 * we get a lot of functionality for free (like a fail-fast iterator)
 * and only need to implement the core methods.
 */
public class CustomCollectionFramework<E> extends AbstractList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public CustomCollectionFramework() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // --- Core methods required by AbstractList for a modifiable list ---

    /**
     * Returns the element at the specified position in this list.
     * This is one of the two methods required by AbstractList for a read-only list.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        @SuppressWarnings("unchecked")
        E element = (E) elementData[index];
        return element;
    }

    /**
     * Returns the number of elements in this list.
     * This is the second method required by AbstractList for a read-only list.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Overriding this method makes the list modifiable.
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        // IMPORTANT: Increment the modification counter from AbstractList.
        // This is what makes the iterators fail-fast.
        modCount++;

        ensureCapacity();
        
        // Shift elements to the right to make space for the new element.
        int numToMove = size - index;
        if (numToMove > 0) {
            System.arraycopy(elementData, index, elementData, index + 1, numToMove);
        }
        
        elementData[index] = element;
        size++;
    }

    /**
     * Removes the element at the specified position in this list.
     * Overriding this method also contributes to making the list modifiable.
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // IMPORTANT: Increment the modification counter.
        modCount++;

        @SuppressWarnings("unchecked")
        E oldValue = (E) elementData[index];

        // Shift elements to the left to fill the gap.
        int numToMove = size - index - 1;
        if (numToMove > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numToMove);
        }

        elementData[--size] = null; // Clear to let GC do its work
        return oldValue;
    }

    /**
     * Helper method to ensure the backing array has enough capacity.
     */
    private void ensureCapacity() {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, size * 2);
        }
    }

    // --- Main method for demonstration ---

    public static void main(String[] args) {
        // Because we extend AbstractList, our class IS-A List.
        List<String> customList = new CustomCollectionFramework<>();

        System.out.println("--- Demonstrating basic List functionality ---");
        customList.add("One");   // Uses add(E e) from AbstractList, which calls our add(int index, E e)
        customList.add("Two");
        customList.add("Three");
        System.out.println("Initial list: " + customList);
        System.out.println("Element at index 1: " + customList.get(1));
        System.out.println("List size: " + customList.size());
        System.out.println("Does it contain 'Two'? " + customList.contains("Two")); // contains() is from AbstractList

        customList.remove("Two"); // remove(Object o) is from AbstractList
        System.out.println("List after removing 'Two': " + customList);

        System.out.println("\n--- Demonstrating Fail-Fast Iterator (from AbstractList) ---");
        try {
            // The for-each loop uses the iterator provided by AbstractList.
            for (String item : customList) {
                System.out.println("Iterating over: " + item);
                if (item.equals("One")) {
                    System.out.println(">> Modifying list directly while iterating...");
                    customList.add("Four"); // This will cause ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(">> Successfully caught expected exception: " + e);
        }
        System.out.println("Final list state: " + customList);
    }
}

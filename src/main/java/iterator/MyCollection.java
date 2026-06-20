package iterator;

import java.util.Iterator;

/**
 * MyCollection is a custom collection class that holds an array of integers.
 * By implementing the Iterable<Integer> interface, we are signaling that this
 * collection can be used in an enhanced for-loop (e.g., "for (Integer value : collection)").
 */
public class MyCollection implements Iterable<Integer> {

    // The underlying data structure for our collection is a simple integer array.
    int[] data = {10, 20, 30, 40};

    /**
     * This is the single method required by the Iterable interface.
     * Its job is to return an Iterator object that knows how to traverse our collection.
     * Here, we return a new instance of our custom MyIterator.
     * @return an Iterator for the elements in this collection.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    /**
     * MyIterator is an inner class that implements the Iterator<Integer> interface.
     * As an inner class, it has direct access to the 'data' array of the outer MyCollection instance.
     * The Iterator is responsible for the actual logic of traversing the data.
     */
    class MyIterator implements Iterator<Integer> {

        // 'index' keeps track of the current position in the iteration.
        // It starts at 0, which is the beginning of the array.
        int index = 0;

        /**
         * The hasNext() method checks if there are more elements to iterate over.
         * It returns true if the current index is still within the bounds of the array,
         * and false otherwise. The for-each loop uses this to know when to stop.
         * @return true if the iteration has more elements.
         */
        @Override
        public boolean hasNext() {
            // If the index is less than the array's length, it means there's at least one more element.
            return index < data.length;
        }

        /**
         * The next() method returns the next element in the sequence.
         * The for-each loop calls this method in each iteration to get the next value.
         * It's crucial to also advance the position (the index) for the next call.
         * @return the next element in the iteration.
         */
        @Override
        public Integer next() {
            // Return the element at the current index, and then increment the index for the next turn.
            // This is known as a post-increment operation.
            return data[index++];
        }
    }

    /**
     * The main method demonstrates how to use our custom MyCollection.
     */
    public static void main(String[] args) {

        // Create an instance of our collection.
        MyCollection collection = new MyCollection();

        /*
         * Because MyCollection implements Iterable, we can use it directly
         * in a for-each loop. Java's compiler translates this loop into code
         * that uses the iterator() method, hasNext(), and next() behind the scenes.
         *
         * What happens:
         * 1. The loop calls collection.iterator() to get the MyIterator instance.
         * 2. It calls hasNext() on the iterator. If it's true...
         * 3. It calls next() to get the value and assigns it to the 'value' variable.
         * 4. The code inside the loop (System.out.println) is executed.
         * 5. Steps 2-4 repeat until hasNext() returns false.
         */
        for(Integer value : collection) {
            // This will print each integer from the 'data' array on a new line.
            System.out.println(value);
        }
    }
}


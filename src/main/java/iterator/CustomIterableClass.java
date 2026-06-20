package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterableClass implements Iterable<Integer> {
    /**
     * Problem 1
     *
     * Create a custom iterable class for:
     *
     * 1 2 3 4 5
     * */

    int [] numbers ={1,2,3,4,5};

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < numbers.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return numbers[currentIndex++];
            }
        };
    }

    public static void main(String[] args) {
        CustomIterableClass myIterable = new CustomIterableClass();

        System.out.println("Iterating over the custom collection:");
        for (Integer number : myIterable) {
            System.out.print(number + " ");
        }
      //  System.out.println();
    }
}

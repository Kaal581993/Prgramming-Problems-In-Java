package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintEvenNumbers {
/**
 * Problem 4
 *
 * Print only even numbers using Iterator.
 * */
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(List.of(4,3,6,8,7,0,9,11,12,15));

        Iterator<Integer> numberIterator = numbers.iterator();
        ArrayList<Integer> evennumber =new ArrayList<>();


        while (numberIterator.hasNext()){
            
            Integer number = numberIterator.next();
            if (number % 2 == 0){
                evennumber.add(number);
            }

        }

        System.out.println("Even numbers: " + evennumber);
    }
}

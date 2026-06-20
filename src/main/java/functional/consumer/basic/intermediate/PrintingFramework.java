package functional.consumer.basic.intermediate;

import java.util.List;
import java.util.function.Consumer;

public class PrintingFramework {

    // A generic method that takes a list and a consumer, and applies the consumer to each item.
    public static <T> void printList(List<T> list, Consumer<T> printer) {
        list.forEach(printer);
    }

    public static void main(String[] args) {
        // Problem 8: Create reusable printing framework.
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<Integer> numbers = List.of(10, 20, 30);

        // Define a specific way to print strings
        Consumer<String> namePrinter = name -> System.out.println("Name: " + name);
        
        // Define a specific way to print numbers
        Consumer<Integer> numberPrinter = number -> System.out.println("Value: " + number);

        System.out.println("--- Printing Names ---");
        printList(names, namePrinter);

        System.out.println("\n--- Printing Numbers ---");
        printList(numbers, numberPrinter);
    }
}

package functional.supplier.basic;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class GenerateCurrentDateTime {
    public static void main(String[] args) {
        // Problem 3: Generate current date and time.
        Supplier<LocalDateTime> dateTimeSupplier = () -> LocalDateTime.now();

        System.out.println("Current date and time: " + dateTimeSupplier.get());
        
        // Wait a moment to see a different time
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        System.out.println("Current date and time: " + dateTimeSupplier.get());
    }
}

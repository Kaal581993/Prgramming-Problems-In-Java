package functional.supplier.basic;

import java.util.UUID;
import java.util.function.Supplier;

public class GenerateUuid {
    public static void main(String[] args) {
        // Problem 5: Generate UUID values.
        Supplier<UUID> uuidSupplier = UUID::randomUUID;

        System.out.println("Generated UUID: " + uuidSupplier.get());
        System.out.println("Generated UUID: " + uuidSupplier.get());
    }
}

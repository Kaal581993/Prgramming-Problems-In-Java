package functional.supplier.intermediate;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class InvoiceIdGenerator {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final String prefix;

    public InvoiceIdGenerator(String prefix) {
        this.prefix = prefix;
    }

    public Supplier<String> getInvoiceIdSupplier() {
        return () -> prefix + "-" + LocalDate.now() + "-" + String.format("%04d", counter.incrementAndGet());
    }

    public static void main(String[] args) {
        // Problem 8: Generate invoice IDs.
        InvoiceIdGenerator generator = new InvoiceIdGenerator("INV");
        Supplier<String> invoiceIdSupplier = generator.getInvoiceIdSupplier();

        System.out.println("New Invoice ID: " + invoiceIdSupplier.get());
        System.out.println("New Invoice ID: " + invoiceIdSupplier.get());
    }
}

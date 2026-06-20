package functional.supplier.advance;

import java.util.function.Supplier;

// A generic wrapper for any lazily-loaded object.
class Lazy<T> implements Supplier<T> {
    private final Supplier<T> supplier;
    private T value;
    private boolean isLoaded = false;

    private Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public static <T> Lazy<T> of(Supplier<T> supplier) {
        return new Lazy<>(supplier);
    }

    @Override
    public T get() {
        // Synchronized block to make it thread-safe
        synchronized (this) {
            if (!isLoaded) {
                System.out.println("Initializing lazily...");
                this.value = supplier.get();
                this.isLoaded = true;
            }
            return this.value;
        }
    }
}

class ExpensiveObject {
    public ExpensiveObject() {
        System.out.println("Creating ExpensiveObject... (takes time)");
        try { Thread.sleep(1500); } catch (InterruptedException e) {}
    }
}

public class LazyLoadingFramework {
    public static void main(String[] args) {
        // Problem 11: Build lazy-loading framework.
        Lazy<ExpensiveObject> lazyObject = Lazy.of(ExpensiveObject::new);

        System.out.println("Lazy object created, but not yet initialized.");

        // The ExpensiveObject is only created on the first call to .get()
        lazyObject.get();
        System.out.println("First get() call complete.");

        // This second call does not re-create the object.
        lazyObject.get();
        System.out.println("Second get() call complete.");
    }
}

package functional.supplier.basic;

import java.util.function.Supplier;

class Car {
    public Car() {
        System.out.println("A new Car object has been created.");
    }
}

public class CreateObjectSupplier {
    public static void main(String[] args) {
        // Problem 4: Create object supplier.
        // The method reference Car::new is a supplier for Car objects.
        Supplier<Car> carSupplier = Car::new;

        // A new Car is created each time .get() is called.
        Car car1 = carSupplier.get();
        Car car2 = carSupplier.get();
    }
}

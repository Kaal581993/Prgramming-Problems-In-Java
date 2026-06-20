package exception_handling.intermediate.widening_checked;

public class WidenedCheckedException {
    public static void main(String[] args) {
        // Polymorphism: Parent reference pointing to a Child object
        Parent obj = new Child();

        // This compiles and runs perfectly!
        // Note: We don't need a try-catch block here because RuntimeException
        // and NullPointerException are unchecked exceptions.
        obj.showData();
    }
}

// Parent class
class Parent {
    // Declares a specific (narrow) unchecked exception
    void showData() throws NullPointerException {
        System.out.println("Parent class method");
    }
}

// Child class inheriting from Parent
class Child extends Parent {
    // Widens the unchecked exception from NullPointerException to RuntimeException
    @Override
    void showData() throws RuntimeException {
        System.out.println("Child class method");
        // We can throw the wider RuntimeException here
        throw new RuntimeException("A general runtime error occurred in Child!");
    }
}


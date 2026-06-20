package functional.consumer.basic;

import java.util.function.Consumer;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + '}';
    }
}

public class PrintEmployeeDetails {
    public static void main(String[] args) {
        // Problem 3: Print employee details.
        Consumer<Employee> printDetails = employee -> System.out.println(employee.toString());

        Employee emp1 = new Employee("Alice", 75000);
        printDetails.accept(emp1);
    }
}

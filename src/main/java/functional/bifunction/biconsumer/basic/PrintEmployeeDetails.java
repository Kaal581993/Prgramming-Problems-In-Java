package functional.bifunction.biconsumer.basic;

import java.util.function.BiConsumer;

class Employee {
    String name;
    double salary;
    public Employee(String name, double salary) { this.name = name; this.salary = salary; }
    @Override public String toString() { return "Employee{name='" + name + "', salary=" + salary + '}'; }
}

public class PrintEmployeeDetails {
    public static void main(String[] args) {
        // Problem 4: Print employee details.
        BiConsumer<Employee, String> printWithContext = (employee, context) ->
                System.out.println("[" + context + "] " + employee.toString());

        Employee emp = new Employee("Alice", 80000);
        printWithContext.accept(emp, "Loading employee data");
    }
}

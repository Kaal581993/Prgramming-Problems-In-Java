package functional.bifunction.biconsumer.intermediate;

import java.util.function.BiConsumer;

class Employee {
    String name;
    double salary;
    public Employee(String name, double salary) { this.name = name; this.salary = salary; }
}

public class SalaryIncrementProcessor {
    public static void main(String[] args) {
        // Problem 7: Implement salary increment processor.
        // This BiConsumer takes an employee and an increment percentage and updates the salary.
        BiConsumer<Employee, Double> incrementSalary = (employee, percentage) -> {
            double newSalary = employee.salary * (1 + percentage / 100);
            System.out.println(
                "Incrementing " + employee.name + "'s salary by " + percentage + "%. New salary: " + newSalary
            );
            employee.salary = newSalary;
        };

        Employee emp = new Employee("Bob", 60000);
        incrementSalary.accept(emp, 5.0);
        System.out.println("Final salary: " + emp.salary);
    }
}

package functional.predicate.basic.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + '}';
    }
}

public class FilterEmployees {
    public static void main(String[] args) {
        // Problem 6: Filter employees by salary (e.g., salary > 60000).
        Predicate<Employee> hasHighSalary = employee -> employee.salary > 60000;

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 70000),
                new Employee("Bob", 50000),
                new Employee("Charlie", 80000),
                new Employee("David", 55000)
        );

        List<Employee> highEarners = employees.stream()
                .filter(hasHighSalary)
                .collect(Collectors.toList());

        System.out.println("Employees with salary > 60000:");
        highEarners.forEach(System.out::println);
    }
}

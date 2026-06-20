package stream.api.basic.intermediate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    String name;
    double salary;
    public Employee(String name, double salary) { this.name = name; this.salary = salary; }
    @Override public String toString() { return "Employee{name='" + name + "', salary=" + salary + '}'; }
}

public class SortEmployees {
    public static void main(String[] args) {
        // Problem 6: Sort employees by salary.
        List<Employee> employees = List.of(
                new Employee("Alice", 80000),
                new Employee("Bob", 60000),
                new Employee("Charlie", 95000)
        );

        // Use the sorted() intermediate operation with a custom Comparator.
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(e -> e.salary))
                .collect(Collectors.toList());

        System.out.println("Sorted employees by salary:");
        sortedEmployees.forEach(System.out::println);
    }
}

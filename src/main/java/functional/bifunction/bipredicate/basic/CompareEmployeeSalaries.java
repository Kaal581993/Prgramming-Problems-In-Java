package functional.bifunction.bipredicate.basic;

import java.util.function.BiPredicate;

class Employee {
    String name;
    double salary;
    public Employee(String name, double salary) { this.name = name; this.salary = salary; }
}

public class CompareEmployeeSalaries {
    public static void main(String[] args) {
        // Problem 4: Compare two employee salaries (e.g., is first salary greater than second).
        BiPredicate<Employee, Employee> isFirstSalaryGreater = (emp1, emp2) -> emp1.salary > emp2.salary;

        Employee alice = new Employee("Alice", 80000);
        Employee bob = new Employee("Bob", 75000);

        System.out.println("Is Alice's salary greater than Bob's? " + isFirstSalaryGreater.test(alice, bob));
        System.out.println("Is Bob's salary greater than Alice's? " + isFirstSalaryGreater.test(bob, alice));
    }
}

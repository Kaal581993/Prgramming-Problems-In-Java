package functional.function.intermediate;

import java.util.function.Function;

class Employee {
    String name;
    double baseSalary;
    public Employee(String name, double baseSalary) { this.name = name; this.baseSalary = baseSalary; }
}

public class SalaryCalculator {
    public static void main(String[] args) {
        // Problem 8: Build salary calculator.
        // This function calculates the final salary by adding a 10% bonus.
        Function<Employee, Double> bonusCalculator = employee -> employee.baseSalary * 1.10;

        Employee emp = new Employee("Bob", 60000);
        double finalSalary = bonusCalculator.apply(emp);

        System.out.println(emp.name + "'s base salary: " + emp.baseSalary);
        System.out.println(emp.name + "'s final salary with bonus: " + finalSalary);
    }
}

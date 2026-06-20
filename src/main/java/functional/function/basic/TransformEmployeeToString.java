package functional.function.basic;

import java.util.function.Function;

class Employee {
    String name;
    public Employee(String name) { this.name = name; }
}

public class TransformEmployeeToString {
    public static void main(String[] args) {
        // Problem 5: Transform employee object to string (get the name).
        // This function takes an Employee object and returns its name as a String.
        Function<Employee, String> getEmployeeName = employee -> employee.name;

        Employee emp = new Employee("Alice");
        String empName = getEmployeeName.apply(emp);

        System.out.println("The employee's name is: " + empName);
    }
}

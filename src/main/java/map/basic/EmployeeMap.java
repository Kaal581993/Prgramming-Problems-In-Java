package map.basic;

import java.util.HashMap;
import java.util.Map;

public class EmployeeMap {
    public static void main(String[] args) {
        // Problem 2: Store employee ID and name.
        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(101, "Alice");
        employeeMap.put(102, "Bob");
        employeeMap.put(103, "Charlie");

        System.out.println("Employee Data: " + employeeMap);
        System.out.println("Employee with ID 102: " + employeeMap.get(102));
    }
}

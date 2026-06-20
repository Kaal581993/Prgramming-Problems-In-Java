package map.treemap.basic;

import java.util.Map;
import java.util.TreeMap;

public class EmployeeMap {
    public static void main(String[] args) {
        // Problem 2: Store employee ID and name using TreeMap.
        // TreeMap will keep the entries sorted by the key (employee ID).
        Map<Integer, String> employeeMap = new TreeMap<>();
        employeeMap.put(103, "Charlie");
        employeeMap.put(101, "Alice");
        employeeMap.put(102, "Bob");

        System.out.println("Employee Data (sorted by ID): " + employeeMap);
    }
}

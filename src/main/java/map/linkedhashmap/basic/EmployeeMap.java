package map.linkedhashmap.basic;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmployeeMap {
    public static void main(String[] args) {
        // Problem 2: Store employee ID and name using LinkedHashMap.
        // The map will preserve the order in which employees were added.
        Map<Integer, String> employeeMap = new LinkedHashMap<>();
        employeeMap.put(101, "Alice");
        employeeMap.put(103, "Charlie");
        employeeMap.put(102, "Bob");

        System.out.println("Employee Data (in insertion order): " + employeeMap);
    }
}

package map.concurrenthashmap.basic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeMap {
    // ConcurrentHashMap provides a thread-safe map for storing shared employee data.
    private final Map<Integer, String> employeeMap = new ConcurrentHashMap<>();

    public void addEmployee(int id, String name) {
        employeeMap.put(id, name);
    }

    public String getEmployee(int id) {
        return employeeMap.get(id);
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 2: Store employee ID and name using ConcurrentHashMap.
        EmployeeMap employees = new EmployeeMap();

        Thread writer1 = new Thread(() -> employees.addEmployee(101, "Alice"));
        Thread writer2 = new Thread(() -> employees.addEmployee(102, "Bob"));

        writer1.start();
        writer2.start();
        writer1.join();
        writer2.join();

        System.out.println("Employee 101: " + employees.getEmployee(101));
        System.out.println("Final Map: " + employees.employeeMap);
    }
}

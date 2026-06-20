package map.weakhashmap.basic;

import java.util.Map;
import java.util.WeakHashMap;

public class EmployeeMap {
    public static void main(String[] args) throws InterruptedException {
        // Problem 2: Store employee ID and name using WeakHashMap.
        // This is only useful if the key is an object that can be garbage collected.
        Map<Integer, String> employeeMap = new WeakHashMap<>();

        Integer id1 = 101; // Autoboxed to new Integer(101)
        Integer id2 = 102;

        employeeMap.put(id1, "Alice");
        employeeMap.put(id2, "Bob");

        System.out.println("Map before GC: " + employeeMap);

        id1 = null; // Remove strong reference to the key
        System.gc();
        Thread.sleep(100);

        // The entry for key 101 may be removed.
        System.out.println("Map after GC: " + employeeMap);
    }
}

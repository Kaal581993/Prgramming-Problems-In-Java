package coding.problems.easy.intermediate.advance;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class SecondHighestNumber {
    public static void main(String[] args) {

        Map<String,Integer> employeeList = new TreeMap<>(Map.ofEntries(
                entry( "Rahul",20000),
                entry("Janice", 40000),
                entry("Ravi", 30000),
                entry("David",60000),
                entry("Gandhi",50000)
        ));

        System.out.println("The employee List:");

        System.out.println("\n");
        System.out.println("+------------+--------+");
        System.out.printf("| %-10s | %-6s |%n", "Employee", "Salary");
        System.out.println("+------------+--------+");

        employeeList.forEach((name, salary) ->
                System.out.printf("| %-10s | %-6d |%n", name, salary)
        );

        System.out.println("+------------+--------+");


        // Stream, sort by salary, and print

        System.out.println("\n");
        System.out.println("The employee List (Sorted by Salary - Ascending):");
        System.out.println("\n");

        System.out.println("+------------+--------+");
        System.out.printf("| %-10s | %-6s |%n", "Employee", "Salary");
        System.out.println("+------------+--------+");

        employeeList.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry ->
                        System.out.printf("| %-10s | %-6d |%n", entry.getKey(), entry.getValue())
                );

        System.out.println("+------------+--------+");

        System.out.println("\n");
        System.out.println("The employee List (Sorted by Salary - Descending):");
        System.out.println("\n");

        System.out.println("+------------+--------+");
        System.out.printf("| %-10s | %-6s |%n", "Employee", "Salary");
        System.out.println("+------------+--------+");

        // Stream, sort by salary descending, and print
        employeeList.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry ->
                        System.out.printf("| %-10s | %-6d |%n", entry.getKey(), entry.getValue())
                );
        System.out.println("+------------+--------+\n");

        Map<String, Integer> secondHighestSalary = employeeList.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .skip(1)        // Skip the 1st element (index 0)
                .limit(1)       // Take only the 2nd element (index 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));


        System.out.println(secondHighestSalary); // Output: {Gandhi=50000}


        System.out.println("\n");
        System.out.println("-------------Second option----------");
        System.out.println("\n");

        Map.Entry<String, Integer> secondHighestEntry = employeeList.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Sorted descending
                .skip(1)        // Skip the 1st element (index 0 - David: 60000)
                .findFirst()    // Get the next element (index 1 - Gandhi: 50000)
                .orElse(null);  // Handle case where map might have fewer than 2 elements
        if (secondHighestEntry != null) {
            System.out.println("Second Highest: " + secondHighestEntry.getKey() + " = " + secondHighestEntry.getValue());
        }

    }
}

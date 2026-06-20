package map.treemap.basic.intermediate;

import java.util.Map;
import java.util.TreeMap;

public class StudentResultSystem {
    // Using TreeMap will keep student IDs and subjects sorted.
    private final Map<String, Map<String, Integer>> studentResults = new TreeMap<>();

    public void addResult(String studentId, String subject, int marks) {
        studentResults.computeIfAbsent(studentId, k -> new TreeMap<>()).put(subject, marks);
    }

    public void displayAllResults() {
        System.out.println("--- All Student Results (Sorted) ---");
        studentResults.forEach((studentId, results) -> {
            System.out.println("Student ID: " + studentId);
            results.forEach((subject, marks) -> System.out.println("  " + subject + ": " + marks));
        });
    }

    public static void main(String[] args) {
        // Problem 8: Build student result system using TreeMap.
        StudentResultSystem system = new StudentResultSystem();
        system.addResult("S102", "Math", 76);
        system.addResult("S101", "Science", 88);
        system.addResult("S101", "Math", 95);

        system.displayAllResults();
    }
}

package map.linkedhashmap.basic.intermediate;

import java.util.LinkedHashMap;
import java.util.Map;

public class StudentResultSystem {
    // Using LinkedHashMap preserves the insertion order of students and their subjects.
    private final Map<String, Map<String, Integer>> studentResults = new LinkedHashMap<>();

    public void addResult(String studentId, String subject, int marks) {
        studentResults.computeIfAbsent(studentId, k -> new LinkedHashMap<>()).put(subject, marks);
    }

    public void displayAllResults() {
        System.out.println("--- All Student Results (in insertion order) ---");
        studentResults.forEach((studentId, results) -> {
            System.out.println("Student ID: " + studentId);
            System.out.println("  " + results);
        });
    }

    public static void main(String[] args) {
        // Problem 8: Build student result system using LinkedHashMap.
        StudentResultSystem system = new StudentResultSystem();
        system.addResult("S102", "Math", 76);
        system.addResult("S101", "Science", 88);
        system.addResult("S101", "Math", 95); // Updates Math for S101

        system.displayAllResults();
    }
}

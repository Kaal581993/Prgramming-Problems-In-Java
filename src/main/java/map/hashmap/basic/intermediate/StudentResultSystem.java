package map.hashmap.basic.intermediate;

import java.util.HashMap;
import java.util.Map;

public class StudentResultSystem {
    // A nested HashMap is a straightforward way to structure this data.
    private final Map<String, Map<String, Integer>> studentResults = new HashMap<>();

    public void addResult(String studentId, String subject, int marks) {
        studentResults.computeIfAbsent(studentId, k -> new HashMap<>()).put(subject, marks);
        System.out.println("Added result for " + studentId + " in " + subject + ": " + marks);
    }

    public void getResultsForStudent(String studentId) {
        Map<String, Integer> results = studentResults.get(studentId);
        if (results == null) {
            System.out.println("No results found for student ID: " + studentId);
            return;
        }
        System.out.println("\n--- Results for Student ID: " + studentId + " ---");
        System.out.println(results);
    }

    public static void main(String[] args) {
        // Problem 8: Build student result system using HashMap.
        StudentResultSystem system = new StudentResultSystem();
        system.addResult("S101", "Math", 95);
        system.addResult("S101", "Science", 88);
        system.addResult("S102", "Math", 76);

        system.getResultsForStudent("S101");
    }
}

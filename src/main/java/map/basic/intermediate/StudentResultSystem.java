package map.basic.intermediate;

import java.util.HashMap;
import java.util.Map;

public class StudentResultSystem {
    // Using a nested map: StudentID -> (Subject -> Marks)
    private final Map<String, Map<String, Integer>> studentResults = new HashMap<>();

    public void addResult(String studentId, String subject, int marks) {
        studentResults.putIfAbsent(studentId, new HashMap<>());
        studentResults.get(studentId).put(subject, marks);
        System.out.println("Added result for " + studentId + " in " + subject + ": " + marks);
    }

    public void getResultsForStudent(String studentId) {
        Map<String, Integer> results = studentResults.get(studentId);
        if (results == null) {
            System.out.println("No results found for student ID: " + studentId);
            return;
        }
        System.out.println("\n--- Results for Student ID: " + studentId + " ---");
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Problem 8: Build student result system.
        StudentResultSystem system = new StudentResultSystem();
        system.addResult("S101", "Math", 95);
        system.addResult("S101", "Science", 88);
        system.addResult("S102", "Math", 76);

        system.getResultsForStudent("S101");
        system.getResultsForStudent("S102");
    }
}

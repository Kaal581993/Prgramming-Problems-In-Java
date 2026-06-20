package map.concurrenthashmap.intermediate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StudentResultSystem {
    // Using nested ConcurrentHashMaps for a fully thread-safe data structure.
    private final Map<String, ConcurrentHashMap<String, Integer>> studentResults = new ConcurrentHashMap<>();

    public void addResult(String studentId, String subject, int marks) {
        studentResults.computeIfAbsent(studentId, k -> new ConcurrentHashMap<>()).put(subject, marks);
    }

    public Map<String, Integer> getResultsForStudent(String studentId) {
        return studentResults.get(studentId);
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 8: Build a thread-safe student result system.
        StudentResultSystem system = new StudentResultSystem();

        Thread t1 = new Thread(() -> system.addResult("S101", "Math", 95));
        Thread t2 = new Thread(() -> system.addResult("S101", "Science", 88));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Results for S101: " + system.getResultsForStudent("S101"));
    }
}

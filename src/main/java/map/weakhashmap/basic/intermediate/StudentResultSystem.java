package map.weakhashmap.basic.intermediate;

import java.util.Map;
import java.util.WeakHashMap;

class Student {
    String studentId;
    public Student(String id) { this.studentId = id; }
    @Override public String toString() { return "Student-" + studentId; }
}

// This class could hold optional, expensive-to-calculate data about a student.
class StudentAnalytics {
    String data;
    public StudentAnalytics(String data) { this.data = data; }
    @Override public String toString() { return "Analytics{" + data + "}"; }
}

public class StudentResultSystem {
    public static void main(String[] args) throws InterruptedException {
        // Problem 8: Use WeakHashMap to store optional metadata about students.
        // The metadata (analytics) will be automatically removed if the student object is garbage collected.
        Map<Student, StudentAnalytics> studentAnalyticsCache = new WeakHashMap<>();

        Student student1 = new Student("101");
        Student student2 = new Student("102");

        studentAnalyticsCache.put(student1, new StudentAnalytics("High Performer"));
        studentAnalyticsCache.put(student2, new StudentAnalytics("Needs Improvement"));

        System.out.println("Analytics cache size: " + studentAnalyticsCache.size());

        // The main application no longer holds a reference to student1
        student1 = null;
        System.gc();
        Thread.sleep(100);

        // The entry for student1 should be gone.
        System.out.println("Analytics cache size after GC: " + studentAnalyticsCache.size());
        System.out.println("Remaining data: " + studentAnalyticsCache);
    }
}

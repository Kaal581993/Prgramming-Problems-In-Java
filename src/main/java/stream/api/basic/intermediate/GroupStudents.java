package stream.api.basic.intermediate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    String name;
    String department;
    public Student(String n, String d) { name = n; department = d; }
    @Override public String toString() { return name; }
}

public class GroupStudents {
    public static void main(String[] args) {
        // Problem 9: Group students by department.
        List<Student> students = List.of(
                new Student("Alice", "CS"),
                new Student("Bob", "EE"),
                new Student("Charlie", "CS"),
                new Student("David", "EE")
        );

        // Collectors.groupingBy() is a powerful terminal operation for this task.
        Map<String, List<Student>> studentsByDept = students.stream()
                .collect(Collectors.groupingBy(student -> student.department));

        System.out.println("Students grouped by department:");
        System.out.println(studentsByDept);
    }
}

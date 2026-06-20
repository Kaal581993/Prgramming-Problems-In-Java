package functional.predicate.basic.intermediate;

import java.util.function.Predicate;

class Student {
    String name;
    double gpa;
    int attendancePercentage;

    public Student(String name, double gpa, int attendance) {
        this.name = name;
        this.gpa = gpa;
        this.attendancePercentage = attendance;
    }
}

public class StudentEligibilityChecker {
    public static void main(String[] args) {
        // Problem 9: Build student eligibility checker.
        // Eligibility: GPA > 3.5 AND attendance > 90%
        Predicate<Student> hasGoodGpa = student -> student.gpa > 3.5;
        Predicate<Student> hasGoodAttendance = student -> student.attendancePercentage > 90;

        Predicate<Student> isEligibleForScholarship = hasGoodGpa.and(hasGoodAttendance);

        Student student1 = new Student("Alice", 3.8, 95);
        Student student2 = new Student("Bob", 3.9, 85);

        System.out.println(student1.name + " is eligible for scholarship? " + isEligibleForScholarship.test(student1));
        System.out.println(student2.name + " is eligible for scholarship? " + isEligibleForScholarship.test(student2));
    }
}

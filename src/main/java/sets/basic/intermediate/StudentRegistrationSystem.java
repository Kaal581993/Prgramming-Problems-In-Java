package sets.basic.intermediate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Problem 9: Implement student registration system.

class RegisteredStudent {
    private final String studentId;
    private final String name;

    public RegisteredStudent(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredStudent that = (RegisteredStudent) o;
        return Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name;
    }
}

public class StudentRegistrationSystem {
    private Set<RegisteredStudent> registeredStudents = new HashSet<>();

    public void registerStudent(String studentId, String name) {
        RegisteredStudent newStudent = new RegisteredStudent(studentId, name);
        if (registeredStudents.add(newStudent)) {
            System.out.println("Registration successful for: " + name);
        } else {
            System.out.println("Student with ID " + studentId + " is already registered.");
        }
    }

    public void displayRegisteredStudents() {
        System.out.println("\n--- Registered Students ---");
        for (RegisteredStudent student : registeredStudents) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentRegistrationSystem system = new StudentRegistrationSystem();
        system.registerStudent("S101", "Alice");
        system.registerStudent("S102", "Bob");
        system.registerStudent("S101", "Alicia"); // Attempt to register with a duplicate ID

        system.displayRegisteredStudents();
    }
}

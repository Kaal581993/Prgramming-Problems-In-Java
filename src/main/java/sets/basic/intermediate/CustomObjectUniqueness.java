package sets.basic.intermediate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Overriding equals() and hashCode() is crucial for custom object uniqueness in Sets
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id; // Uniqueness is based on the student's ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}

public class CustomObjectUniqueness {
    public static void main(String[] args) {
        // Problem 6: Implement custom object uniqueness.
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(101, "Alice"));
        studentSet.add(new Student(102, "Bob"));
        studentSet.add(new Student(101, "Alicia")); // This is a duplicate based on ID

        System.out.println("Set of students (uniqueness based on ID):");
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }
}

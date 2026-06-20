package functional.consumer.basic.intermediate;

import java.util.List;
import java.util.function.Consumer;

class Student {
    String name;
    double gpa;
    public Student(String name, double gpa) { this.name = name; this.gpa = gpa; }
}

public class ProcessReportCards {

    // Consumer to print the report card to the console
    public static final Consumer<Student> CONSOLE_REPORTER = student -> {
        System.out.println("--- Report Card for " + student.name + " ---");
        System.out.println("GPA: " + student.gpa);
        System.out.println("--------------------------");
    };

    // Consumer to email the report card (simulated)
    public static final Consumer<Student> EMAIL_REPORTER = student ->
            System.out.println("Emailing report card for " + student.name + "...");


    public static void main(String[] args) {
        // Problem 9: Process student report cards.
        List<Student> students = List.of(
                new Student("Alice", 3.8),
                new Student("Bob", 3.2)
        );

        // Create a processor that both prints and emails the report
        Consumer<Student> reportProcessor = CONSOLE_REPORTER.andThen(EMAIL_REPORTER);

        students.forEach(reportProcessor);
    }
}

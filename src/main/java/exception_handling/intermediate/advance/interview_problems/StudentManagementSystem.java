package exception_handling.intermediate.advance.interview_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class StudentManagementSystem {

    private static final Map<String, Long> students = new HashMap<>();

    public static void main(String[] args) {

        // 1. Populate the map with 10 entries
        for (int i = 1; i <= 10; i++) {
            String studentName = String.format("ACC%03d", i); // e.g., ACC001, ACC002...
            long marks = i * 10L;                    // e.g., 1000, 2000...
            students.put(studentName, marks);

        }

        // 2. Print all accounts
        System.out.println("--- Current Student List ---");
        students.forEach((studentName, marks) ->
                System.out.println("Student Name: " + studentName + " | Marks: " + marks)
        );

        try {
            System.out.println("Enter the choice of operation you want to perform: \n" +
                    "1. Add Student\n" +
                    "2. Update Student\n" +
                    "3. Delete Student\n" +
                    "4. Search Student");

            Scanner scan = new Scanner(System.in);

            int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the Student's Name");
                        String name = scan.next();

                        System.out.println("Enter the Student's marks");
                        Long marks = scan.nextLong();

                        // Check for duplicate student before adding
                        if (students.containsKey(name)) {
                            throw new DuplicateStudentException("Student '" + name + "' already exists");
                        }
                        // Validate marks
                        if (marks < 0 || marks > 100) {
                            throw new InvalidMarksException("Marks must be between 0 and 100");
                        }
                        students.put(name, marks);
                        System.out.println("--- New Student List ---");
                        students.forEach((studentName, mark) ->
                                System.out.println("Student Name: " + studentName + " | Marks: " + marks)
                        );
                        break;

                    case 2:
                        System.out.println("Enter the Student name for which you want to update marks");
                        name = scan.next();

                        System.out.println("Enter the Student's marks");
                        marks = scan.nextLong();

                        // Check if student exists before updating
                        if (!students.containsKey(name)) {
                            throw new StudentNotFoundException("Student '" + name + "' not found");
                        }
                        // Validate marks
                        if (marks < 0 || marks > 100) {
                            throw new InvalidMarksException("Marks must be between 0 and 100");
                        }
                        students.replace(name, marks);

                        System.out.println("--- New Student List ---");
                        students.forEach((studentName, mark) ->
                                System.out.println("Student Name: " + studentName + " | Marks: " + marks)
                        );
                        break;

                    case 3:
                        System.out.println("Enter the Student name which you want to remove");
                        name = scan.next();

                        // Check if student exists before deleting
                        if (!students.containsKey(name)) {
                            throw new StudentNotFoundException("Student '" + name + "' not found");
                        }
                        students.remove(name);
                        System.out.println("--- New Student List ---");
                        students.forEach((studentName, mark) ->
                                System.out.println("Student Name: " + studentName + " | Marks: " + mark)
                        );
                        break;

                    case 4:
                        System.out.println("Enter the Student name to search");
                        name = scan.next();

                        if (!students.containsKey(name)) {
                            throw new StudentNotFoundException("Student '" + name + "' not found");
                        }
                        System.out.println("Student found: " + name + " with marks: " + students.get(name));

                        break;
                    default:
                        System.out.println("Invalid choice. Exiting...");
                        return;
                }

        } catch (DuplicateStudentException de) {
            System.err.println("Student Already Exists: " + de.getMessage());
        } catch (StudentNotFoundException se) {
            System.err.println("Student Not Found: " + se.getMessage());
        } catch (InvalidMarksException ime) {
            System.err.println("Invalid Marks: " + ime.getMessage());
        }
    }

}



// Custom exception classes defined first
class DuplicateStudentException extends Exception {
    public DuplicateStudentException(String message) {
        super(message);
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

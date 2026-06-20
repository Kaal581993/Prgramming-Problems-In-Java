package functional.bifunction.bipredicate.intermediate;

import java.util.function.BiPredicate;

class Student {
    String name;
    double gpa;
    public Student(String name, double gpa) { this.name = name; this.gpa = gpa; }
}

class EligibilityCriteria {
    double minGpa;
    public EligibilityCriteria(double minGpa) { this.minGpa = minGpa; }
}

public class StudentEligibilityChecker {
    public static void main(String[] args) {
        // Problem 6: Build student eligibility checker.
        // This BiPredicate checks if a student meets a given criteria.
        BiPredicate<Student, EligibilityCriteria> isEligible = (student, criteria) ->
                student.gpa >= criteria.minGpa;

        Student alice = new Student("Alice", 3.8);
        EligibilityCriteria scholarshipCriteria = new EligibilityCriteria(3.5);

        System.out.println(alice.name + " is eligible for the scholarship? " + isEligible.test(alice, scholarshipCriteria));
    }
}

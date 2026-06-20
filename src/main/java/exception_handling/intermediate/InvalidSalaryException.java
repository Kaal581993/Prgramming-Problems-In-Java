package exception_handling.intermediate;

public class InvalidSalaryException extends Exception{

    public static void main(String[] args) {
        int salary= 5000;



        try {
            salaryValidation(salary);
        } catch (InvalidSalaryException e) {
            // Catch the custom exception specifically
            System.err.println("Transaction Failed: " + e.getMessage());
        }
    }

    private static void salaryValidation(int salary) throws InvalidSalaryException{
        if (salary < 10000) {
            // Throw the custom exception
            throw new InvalidSalaryException("Salary is invalid");
        }
    }

    public InvalidSalaryException(String message) {
        super(message);
    }
}


/**
 *
 *
 * the provided code correctly solves the problem.
 *
 * Why the code is correct:
 * Custom Exception Creation: It defines InvalidSalaryException which extends the standard Exception class, making it a checked exception.
 * Constructor: The constructor public InvalidSalaryException(String message) correctly calls super(message) to store the detail message.
 * Exception Rule Evaluation: Inside salaryValidation, the condition salary < 10000 is checked. If salary is less than 10000 (e.g., 5000 in the main method), it throws the custom exception via throw new InvalidSalaryException("Salary is invalid");.
 * Try-Catch Block: The main method invokes the validation method inside a try block and catches InvalidSalaryException specifically, handling it gracefully and printing the error output:
 * text
 *
 *
 * Transaction Failed: Salary is invalid
 * Recommended Best Practice Improvement
 * While putting the main driver method and helper methods inside the exception class compiles and runs successfully, in standard Java development it is best practice to separate the exception definition from the application logic.
 *
 * Here is how you would split it into two separate files:
 *
 * 1. The Custom Exception Class: InvalidSalaryException.java
 * java
 *
 *
 * package exception_handling.intermediate;
 * public class InvalidSalaryException extends Exception {
 *     public InvalidSalaryException(String message) {
 *         super(message);
 *     }
 * }
 * 2. The Driver/Validation Class: SalaryValidator.java
 * java
 *
 *
 * package exception_handling.intermediate;
 * public class SalaryValidator {
 *     public static void main(String[] args) {
 *         int salary = 5000;
 *         try {
 *             salaryValidation(salary);
 *         } catch (InvalidSalaryException e) {
 *             System.err.println("Transaction Failed: " + e.getMessage());
 *         }
 *     }
 *     private static void salaryValidation(int salary) throws InvalidSalaryException {
 *         if (salary < 10000) {
 *             throw new InvalidSalaryException("Salary is invalid");
 *         }
 *     }
 * }
 * 17
 *
 *
 * */
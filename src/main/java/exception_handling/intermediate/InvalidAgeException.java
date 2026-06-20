//package exception_handling.intermediate;
//
//public class InvalidAgeException {
//    public static void main(String[] args) {
//        int age = 15;
//
//        try {
//            ageValidation(age);
//        }catch (Exception e){
//            System.err.println("Transaction Failed: " + e.getMessage());
//
//        }
//
//    }
//
//    private static void ageValidation(int age) {
//        if(age < 18){
//            throw new RuntimeException("Age is invalid");
//        }
//    }
//}


/***
 *
 * The provided code does not satisfy the problem requirements.
 *
 * Why the code fails to meet the requirements:
 * No Custom Exception Class: A custom exception in Java must extend either
 * Exception (for a checked exception) or RuntimeException
 * (for an unchecked exception). In your code, InvalidAgeException
 * is just a standard class containing the main and ageValidation methods.
 *
 * Throws a Standard Exception: Inside the ageValidation method, you throw
 * a generic RuntimeException (throw new RuntimeException("Age is invalid");)
 * instead of throwing a custom InvalidAgeException.
 *
 * Catch Block is Generic: You are catching Exception instead of catching your
 * custom exception specifically.
 * Corrected Implementation
 *
 * Depending on whether you want your custom exception to be checked
 * (must be declared in the throws clause or handled) or unchecked
 * (extends RuntimeException), you can implement it in one of the following ways.
 * */

//Option A: Custom Checked Exception (Recommended)
//This approach extends Exception and forces the caller to handle the exception.

package exception_handling.intermediate;

// 1. Create the custom exception by extending Exception
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }

    // 2. Main method to test the custom exception
    public static void main(String[] args) {
        int age = 15;

        try {
            ageValidation(age);
        } catch (InvalidAgeException e) { // Catch the custom exception specifically
            System.err.println("Transaction Failed: " + e.getMessage());
        }
    }

    // 3. Declare that this method throws the custom exception
    private static void ageValidation(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throw the custom exception
            throw new InvalidAgeException("Age is invalid");
        }
    }
}

//Option B: Custom Unchecked Exception
//This approach extends RuntimeException, which does not force
// the caller to explicitly declare or catch it (though it is still
// good practice to catch it).


/**
 * package exception_handling.intermediate;
 *
 * // 1. Create the custom exception by extending RuntimeException
 * public class InvalidAgeException extends RuntimeException {
 *     public InvalidAgeException(String message) {
 *         super(message);
 *     }
 *
 *     // 2. Main method to test the custom exception
 *     public static void main(String[] args) {
 *         int age = 15;
 *
 *         try {
 *             ageValidation(age);
 *         } catch (InvalidAgeException e) {
 *         // Catch the custom exception specifically
 *             System.err.println("Transaction Failed: " + e.getMessage());
 *         }
 *     }
 *
 *     // 3. Unchecked exceptions do not require a 'throws' declaration
 *     private static void ageValidation(int age) {
 *         if (age < 18) {
 *             // Throw the custom exception
 *             throw new InvalidAgeException("Age is invalid");
 *         }
 *     }
 * }
 * */



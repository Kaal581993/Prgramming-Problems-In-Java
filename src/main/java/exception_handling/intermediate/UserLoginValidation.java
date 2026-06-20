//package exception_handling.intermediate;
//
//public class UserLoginValidation {
//
//
//    public static void main(String[] args) {
//
//        String username = "";
//
//        String password = "";
//
//        System.out.println("--- Test Case 1: No exception ---");
//        testNoException(username, password);
//        System.out.println();
//
//        System.out.println("--- Test Case 2: Exception occurs ---");
//        testExceptionOccurs(username, password);
//        System.out.println();
//
//
//    }
//
//    // Test Case 1: No exception occurs
//    public static void testNoException(String username, String password) {
//
//        username = "Kaal";
//        password ="kaal";
//        try {
//            if(!username.isEmpty()){
//                System.out.println("Username is:"+username);
//                try{
//                    if(!password.isEmpty()){
//                        System.out.println("Username is:"+username);
//                    }
//                }catch (RuntimeException nre){
//                    throw new RuntimeException("Password cannot be empty");
//                }
//            }
//        } catch (RuntimeException re) {
//            throw new RuntimeException("Username cannot be empty");
//
//        }
//    }
//
//    // Test Case 2: Exception occurs
//    public static void testExceptionOccurs(String username, String password) {
//        try {
//            if(!username.isEmpty()){
//                System.out.println("Username is:"+username);
//
//            }
//        } catch (RuntimeException re) {
//            throw new RuntimeException("Username cannot be empty");
//            try{
//                if(!password.isEmpty()){
//                    System.out.println("Username is:"+username);
//                }
//            }catch (RuntimeException nre){
//                throw new RuntimeException("Password cannot be empty");
//            }
//        }
//    }
//
//}

// this solution is not correct!

/**
 * In your code, the test cases do not behave as expected
 * due to two main logical issues:
 *
 * Issue 1: No Exceptions are Ever Thrown
 * In Java, exceptions do not get thrown automatically just because
 * an if condition evaluates to false.
 *
 * In testExceptionOccurs, username is empty ("").
 * The code checks if (!username.isEmpty()), which evaluates to false.
 * As a result, the code inside the if block is simply skipped.
 * Since no exception is thrown inside the try block, the catch
 * (RuntimeException re) block is never executed.
 * The program finishes silently without triggering the error message.
 * To fix this, you must explicitly throw an exception using the throw
 * keyword when the validation fails.
 *
 * Issue 2: Exception Masking (Improper Nesting)
 * Because the inner try-catch block is nested inside the outer try block,
 * any exception thrown or re-thrown by the inner catch block
 * (e.g., "Password cannot be empty") will be caught by the outer
 * catch (RuntimeException re) block.
 *
 * Consequently, even if you fix Issue 1, a password validation error
 * will get caught by the outer catch and incorrectly re-thrown as
 * "Username cannot be empty".
 *
 * Corrected Implementation
 * Here is how you can restructure the code to properly validate the
 * fields, throw the correct exceptions, and handle them in main:
 * */


/**
 *Problem 8: User Login Validation
 *
 * Simulate login validation.
 *
 * Requirements
 *
 * Throw exception if:
 *
 * Username is empty
 * Password is empty
 *
 * Handle appropriately.
 * */

package exception_handling.intermediate;

public class UserLoginValidation {

    public static void main(String[] args) {
        System.out.println("--- Test Case 1: No exception ---");
        try {
            validateLogin("Kaal", "kaal");
            System.out.println("Login validation successful!");
        } catch (RuntimeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
        System.out.println();

        System.out.println("--- Test Case 2: Exception occurs (Empty Username) ---");
        try {
            validateLogin("", "kaal");
        } catch (RuntimeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
        System.out.println();

        System.out.println("--- Test Case 3: Exception occurs (Empty Password) ---");
        try {
            validateLogin("Kaal", "");
        } catch (RuntimeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
        System.out.println();
    }

    // Single method to validate inputs and throw appropriate exceptions
    public static void validateLogin(String username, String password) {
        // Validate Username
        if (username == null || username.isEmpty()) {
            throw new RuntimeException("Username cannot be empty");
        }
        System.out.println("Username is valid: " + username);

        // Validate Password
        if (password == null || password.isEmpty()) {
            throw new RuntimeException("Password cannot be empty");
        }
        System.out.println("Password is valid.");
    }
}
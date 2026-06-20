package functional.predicate.basic;

import java.util.function.Predicate;

public class ValidatePasswordLength {
    public static void main(String[] args) {
        // Problem 5: Validate password length (e.g., must be more than 8 characters).
        Predicate<String> isPasswordLengthValid = password -> password != null && password.length() > 8;

        String pass1 = "short";
        String pass2 = "longandsecurepassword";

        System.out.println("Is password '" + pass1 + "' valid? " + isPasswordLengthValid.test(pass1));
        System.out.println("Is password '" + pass2 + "' valid? " + isPasswordLengthValid.test(pass2));
    }
}

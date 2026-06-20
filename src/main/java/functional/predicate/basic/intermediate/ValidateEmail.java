package functional.predicate.basic.intermediate;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ValidateEmail {
    public static void main(String[] args) {
        // Problem 7: Validate email addresses.
        // A simple regex for demonstration. Real-world regex is more complex.
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Predicate<String> isEmailValid = email -> Pattern.matches(emailRegex, email);

        String email1 = "test@example.com";
        String email2 = "invalid-email";

        System.out.println("Is '" + email1 + "' a valid email? " + isEmailValid.test(email1));
        System.out.println("Is '" + email2 + "' a valid email? " + isEmailValid.test(email2));
    }
}

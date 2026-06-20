package functional.predicate.basic.intermediate.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class ValidationRule<T> {
    final Predicate<T> predicate;
    final String errorMessage;

    public ValidationRule(Predicate<T> predicate, String errorMessage) {
        this.predicate = predicate;
        this.errorMessage = errorMessage;
    }
}

class Validator<T> {
    private final List<ValidationRule<T>> rules = new ArrayList<>();

    public void addRule(Predicate<T> predicate, String message) {
        rules.add(new ValidationRule<>(predicate, message));
    }

    public List<String> validate(T object) {
        List<String> errors = new ArrayList<>();
        for (ValidationRule<T> rule : rules) {
            if (!rule.predicate.test(object)) {
                errors.add(rule.errorMessage);
            }
        }
        return errors;
    }
}

class User {
    String username;
    String email;
    public User(String username, String email) { this.username = username; this.email = email; }
}

public class CustomValidationFramework {
    public static void main(String[] args) {
        // Problem 12: Implement custom validation framework.
        Validator<User> userValidator = new Validator<>();
        userValidator.addRule(u -> u.username != null && !u.username.isEmpty(), "Username cannot be empty.");
        userValidator.addRule(u -> u.username.length() > 5, "Username must be longer than 5 characters.");
        userValidator.addRule(u -> u.email.contains("@"), "Email must be valid.");

        User user1 = new User("test", "test@example.com");
        List<String> errors1 = userValidator.validate(user1);
        System.out.println("Errors for user1: " + errors1);

        User user2 = new User("validuser", "valid@email.com");
        List<String> errors2 = userValidator.validate(user2);
        System.out.println("Errors for user2: " + errors2);
    }
}

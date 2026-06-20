package functional.bifunction.bipredicate.intermediate;

import java.util.Map;
import java.util.function.BiPredicate;

class UserCredentials {
    String username;
    String password;
    public UserCredentials(String u, String p) { username = u; password = p; }
}

// Simulates a user database
class UserDatabase {
    private final Map<String, String> users = Map.of("alice", "pass123", "bob", "secure456");
    public String getPasswordFor(String username) { return users.get(username); }
}

public class CustomAuthValidator {
    public static void main(String[] args) {
        // Problem 9: Build custom authentication validator.
        // This BiPredicate checks if the credentials are valid against a user database.
        BiPredicate<UserCredentials, UserDatabase> validator = (creds, db) -> {
            String storedPassword = db.getPasswordFor(creds.username);
            return storedPassword != null && storedPassword.equals(creds.password);
        };

        UserDatabase db = new UserDatabase();
        UserCredentials validCreds = new UserCredentials("alice", "pass123");
        UserCredentials invalidCreds = new UserCredentials("alice", "wrongpass");

        System.out.println("Are credentials for 'alice'/'pass123' valid? " + validator.test(validCreds, db));
        System.out.println("Are credentials for 'alice'/'wrongpass' valid? " + validator.test(invalidCreds, db));
    }
}

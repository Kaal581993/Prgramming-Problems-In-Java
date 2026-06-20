package functional.bifunction.biconsumer.intermediate;

import java.time.LocalDateTime;
import java.util.function.BiConsumer;

class User {
    String username;
    public User(String name) { this.username = name; }
}

public class AuditLoggingFramework {
    // This BiConsumer logs an action performed by a user.
    public static final BiConsumer<User, String> AUDIT_LOGGER = (user, action) -> {
        System.out.println(
            "[" + LocalDateTime.now() + "] User '" + user.username + "' performed action: " + action
        );
    };

    public static void main(String[] args) {
        // Problem 6: Build audit logging framework.
        User currentUser = new User("alice");

        AUDIT_LOGGER.accept(currentUser, "Logged in");
        AUDIT_LOGGER.accept(currentUser, "Viewed dashboard");
    }
}

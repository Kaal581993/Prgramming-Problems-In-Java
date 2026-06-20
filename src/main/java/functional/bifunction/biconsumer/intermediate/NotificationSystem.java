package functional.bifunction.biconsumer.intermediate;

import java.util.function.BiConsumer;

class User {
    String name;
    String email;
    public User(String name, String email) { this.name = name; this.email = email; }
}

public class NotificationSystem {
    // This BiConsumer sends a specific message to a user's email.
    public static final BiConsumer<User, String> EMAIL_NOTIFIER = (user, message) -> {
        System.out.println("--- Sending Email ---");
        System.out.println("To: " + user.email);
        System.out.println("Subject: Notification for " + user.name);
        System.out.println("Body: " + message);
        System.out.println("---------------------");
    };

    public static void main(String[] args) {
        // Problem 10: Implement notification system.
        User user = new User("Charlie", "charlie@example.com");
        String message = "Your order has been shipped.";

        EMAIL_NOTIFIER.accept(user, message);
    }
}

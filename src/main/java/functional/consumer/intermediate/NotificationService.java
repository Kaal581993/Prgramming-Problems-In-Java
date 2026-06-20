package functional.consumer.intermediate;

import java.util.List;
import java.util.function.Consumer;

class User {
    String name;
    String email;
    String phoneNumber;
    public User(String name, String email, String phone) { this.name = name; this.email = email; this.phoneNumber = phone; }
}

public class NotificationService {

    // Consumer for sending an email
    public static final Consumer<User> EMAIL_NOTIFIER = user ->
            System.out.println("Sending email to " + user.email + " for user " + user.name);

    // Consumer for sending an SMS
    public static final Consumer<User> SMS_NOTIFIER = user ->
            System.out.println("Sending SMS to " + user.phoneNumber + " for user " + user.name);

    public void sendNotifications(List<User> users, Consumer<User> notificationMethod) {
        users.forEach(notificationMethod);
    }

    public static void main(String[] args) {
        // Problem 10: Implement notification service.
        List<User> users = List.of(
                new User("Alice", "alice@example.com", "111-1111"),
                new User("Bob", "bob@example.com", "222-2222")
        );

        NotificationService service = new NotificationService();

        System.out.println("--- Sending Email Notifications ---");
        service.sendNotifications(users, EMAIL_NOTIFIER);

        System.out.println("\n--- Sending SMS and Email Notifications ---");
        service.sendNotifications(users, EMAIL_NOTIFIER.andThen(SMS_NOTIFIER));
    }
}

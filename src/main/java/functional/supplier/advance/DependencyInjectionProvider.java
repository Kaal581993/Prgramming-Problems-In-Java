package functional.supplier.advance;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// A very simple DI container
class DIContainer {
    private final Map<Class<?>, Supplier<?>> registry = new HashMap<>();

    public <T> void register(Class<T> type, Supplier<T> supplier) {
        registry.put(type, supplier);
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> type) {
        Supplier<T> supplier = (Supplier<T>) registry.get(type);
        if (supplier == null) {
            throw new IllegalArgumentException("No provider registered for type: " + type.getName());
        }
        return supplier.get();
    }
}

// Example services
interface NotificationService { void send(String message); }
class EmailService implements NotificationService {
    public EmailService() { System.out.println("EmailService created."); }
    public void send(String message) { System.out.println("Sending email: " + message); }
}
class AppController {
    private final NotificationService notificationService;
    public AppController(NotificationService service) { this.notificationService = service; }
    public void doWork() { notificationService.send("Hello from AppController!"); }
}

public class DependencyInjectionProvider {
    public static void main(String[] args) {
        // Problem 12: Implement dependency injection provider.
        DIContainer container = new DIContainer();

        // Register a singleton provider for the NotificationService
        container.register(NotificationService.class, Lazy.of(EmailService::new));
        
        // Register a provider for the AppController that resolves its dependencies from the container
        container.register(AppController.class, () -> new AppController(container.getInstance(NotificationService.class)));

        System.out.println("Container configured. Getting AppController...");
        AppController controller = container.getInstance(AppController.class);
        controller.doWork();
        
        // Getting the controller again might create a new one, but it will reuse the singleton EmailService
        AppController controller2 = container.getInstance(AppController.class);
    }
}

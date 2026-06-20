package functional.consumer.basic.intermediate.advance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

// A generic event object
class Event<T> {
    String type;
    T data;
    public Event(String type, T data) { this.type = type; this.data = data; }
}

// The central event bus or dispatcher
public class EventDrivenSystem {
    private final Map<String, List<Consumer<Object>>> subscribers = new HashMap<>();

    // Subscribe a consumer to a specific event type
    @SuppressWarnings("unchecked")
    public <T> void subscribe(String eventType, Consumer<T> listener) {
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>())
                   .add((Consumer<Object>) listener);
    }

    // Publish an event to all interested subscribers
    public <T> void publish(Event<T> event) {
        List<Consumer<Object>> listeners = subscribers.get(event.type);
        if (listeners != null) {
            listeners.forEach(listener -> listener.accept(event.data));
        }
    }

    public static void main(String[] args) {
        // Problem 11: Build event-driven processing system.
        EventDrivenSystem eventBus = new EventDrivenSystem();

        // Subscriber 1: Listens for user login events
        eventBus.subscribe("USER_LOGIN", (String username) -> 
            System.out.println("AUDIT_LOG: User '" + username + "' logged in."));

        // Subscriber 2: Listens for order placement events
        eventBus.subscribe("ORDER_PLACED", (Double amount) -> 
            System.out.println("INVENTORY_SERVICE: Order for $" + amount + " received. Adjusting stock."));

        // Publish some events
        eventBus.publish(new Event<>("USER_LOGIN", "Alice"));
        eventBus.publish(new Event<>("ORDER_PLACED", 199.99));
    }
}

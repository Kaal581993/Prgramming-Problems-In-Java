package functional.bifunction.biconsumer.advance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class EventProcessingEngine {
    // The registry holds a list of BiConsumers for each event type.
    // The BiConsumer takes the event data and a context/metadata object.
    private final Map<String, List<BiConsumer<Object, Map<String, Object>>>> subscribers = new HashMap<>();

    public <T> void subscribe(String eventType, BiConsumer<T, Map<String, Object>> listener) {
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>())
                   .add((data, metadata) -> listener.accept((T) data, metadata));
    }

    public <T> void publish(String eventType, T data, Map<String, Object> metadata) {
        List<BiConsumer<Object, Map<String, Object>>> listeners = subscribers.get(eventType);
        if (listeners != null) {
            listeners.forEach(listener -> listener.accept(data, metadata));
        }
    }

    public static void main(String[] args) {
        // Problem 11: Build event processing engine.
        EventProcessingEngine engine = new EventProcessingEngine();

        // Subscribe a logger to all "USER_ACTION" events
        engine.subscribe("USER_ACTION", (String action, Map<String, Object> metadata) -> {
            System.out.println(
                "[AUDIT] User '" + metadata.get("username") + "' performed action: " + action
            );
        });

        Map<String, Object> metadata = Map.of("username", "alice", "ip", "127.0.0.1");
        engine.publish("USER_ACTION", "Clicked 'Save'", metadata);
    }
}

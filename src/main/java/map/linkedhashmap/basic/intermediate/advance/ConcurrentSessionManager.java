package map.linkedhashmap.basic.intermediate.advance;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class ConcurrentSessionManager {
    // Using a synchronized LinkedHashMap to maintain session creation order.
    private final Map<String, String> activeSessions = Collections.synchronizedMap(new LinkedHashMap<>());

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        activeSessions.put(sessionId, userId);
        System.out.println("Session created for " + userId);
        return sessionId;
    }

    public void displaySessions() {
        // To prevent ConcurrentModificationException, we need to lock during iteration.
        synchronized (activeSessions) {
            System.out.println("--- Active Sessions (in creation order) ---");
            activeSessions.forEach((id, userId) -> System.out.println(userId + ": " + id));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 13: Implement concurrent session manager using LinkedHashMap.
        ConcurrentSessionManager sessionManager = new ConcurrentSessionManager();

        Thread t1 = new Thread(() -> sessionManager.createSession("user1"));
        Thread t2 = new Thread(() -> sessionManager.createSession("user2"));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        sessionManager.displaySessions();
    }
}

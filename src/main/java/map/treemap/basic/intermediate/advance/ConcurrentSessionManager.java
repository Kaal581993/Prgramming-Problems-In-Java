package map.treemap.basic.intermediate.advance;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

class UserSession {
    private final String userId;
    public UserSession(String userId) { this.userId = userId; }
}

public class ConcurrentSessionManager {
    // TreeMap is not thread-safe and requires manual synchronization.
    // It would only be chosen if sorted access to session IDs was a requirement.
    private final Map<String, UserSession> activeSessions = new TreeMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        synchronized (activeSessions) {
            activeSessions.put(sessionId, new UserSession(userId));
        }
        return sessionId;
    }

    public void displaySessions() {
        synchronized (activeSessions) {
            System.out.println("--- Active Sessions (Sorted by Session ID) ---");
            activeSessions.forEach((id, session) -> System.out.println(id));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 13: Implement concurrent session manager using a synchronized TreeMap.
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

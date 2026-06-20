package map.hashmap.basic.intermediate.advance;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class UserSession {
    private final String userId;
    public UserSession(String userId) { this.userId = userId; }
    @Override public String toString() { return "UserSession{userId='" + userId + "'}"; }
}

public class ConcurrentSessionManager {
    // Using a HashMap requires manual synchronization for thread safety.
    private final Map<String, UserSession> activeSessions = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        synchronized (activeSessions) {
            activeSessions.put(sessionId, new UserSession(userId));
        }
        System.out.println("Session created for " + userId);
        return sessionId;
    }

    public UserSession getSession(String sessionId) {
        synchronized (activeSessions) {
            return activeSessions.get(sessionId);
        }
    }

    public void invalidateSession(String sessionId) {
        synchronized (activeSessions) {
            activeSessions.remove(sessionId);
        }
        System.out.println("Session invalidated: " + sessionId);
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 13: Implement concurrent session manager using a synchronized HashMap.
        ConcurrentSessionManager sessionManager = new ConcurrentSessionManager();

        Thread t1 = new Thread(() -> sessionManager.createSession("user1"));
        Thread t2 = new Thread(() -> sessionManager.createSession("user2"));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Total active sessions: " + sessionManager.activeSessions.size());
    }
}

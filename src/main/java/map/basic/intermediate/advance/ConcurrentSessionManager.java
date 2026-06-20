package map.basic.intermediate.advance;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class UserSession {
    // Session data would go here
    private final String userId;

    public UserSession(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserSession{" + "userId='" + userId + '\'' + '}';
    }
}

public class ConcurrentSessionManager {
    // ConcurrentHashMap is ideal for managing sessions in a multi-threaded environment
    private final Map<String, UserSession> activeSessions = new ConcurrentHashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        activeSessions.put(sessionId, new UserSession(userId));
        System.out.println("Session created for " + userId + ": " + sessionId);
        return sessionId;
    }

    public UserSession getSession(String sessionId) {
        return activeSessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        UserSession removedSession = activeSessions.remove(sessionId);
        if (removedSession != null) {
            System.out.println("Session invalidated: " + sessionId);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 13: Implement concurrent session manager.
        ConcurrentSessionManager sessionManager = new ConcurrentSessionManager();

        // Simulate multiple threads creating and accessing sessions
        Thread user1 = new Thread(() -> {
            String sessionId = sessionManager.createSession("user1");
            System.out.println("User1 session data: " + sessionManager.getSession(sessionId));
        });

        Thread user2 = new Thread(() -> {
            String sessionId = sessionManager.createSession("user2");
            sessionManager.invalidateSession(sessionId);
        });

        user1.start();
        user2.start();
        user1.join();
        user2.join();
        
        System.out.println("\nFinal active sessions: " + sessionManager.activeSessions.size());
    }
}

package map.concurrenthashmap.advance;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class UserSession {
    private final String userId;
    public UserSession(String userId) { this.userId = userId; }
}

public class ConcurrentSessionManager {
    // ConcurrentHashMap is the ideal choice for a high-performance, thread-safe session manager.
    private final Map<String, UserSession> activeSessions = new ConcurrentHashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        activeSessions.put(sessionId, new UserSession(userId));
        System.out.println("Session created for " + userId);
        return sessionId;
    }

    public UserSession getSession(String sessionId) {
        return activeSessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        activeSessions.remove(sessionId);
        System.out.println("Session invalidated: " + sessionId);
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 13: Implement concurrent session manager using ConcurrentHashMap.
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

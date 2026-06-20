package map.weakhashmap.basic.intermediate.advance;

import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.Collections;

class UserSession {
    String sessionId = UUID.randomUUID().toString();
}

public class ConcurrentSessionManager {
    // The map holds metadata about a session. The session is the key.
    // When the app loses all references to the UserSession object, the metadata is automatically cleared.
    private final Map<UserSession, String> sessionMetadata = Collections.synchronizedMap(new WeakHashMap<>());

    public void addMetadata(UserSession session, String metadata) {
        sessionMetadata.put(session, metadata);
    }

    public int getActiveSessionCount() {
        return sessionMetadata.size();
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 13: Implement a session manager where sessions are keys in a WeakHashMap.
        ConcurrentSessionManager manager = new ConcurrentSessionManager();
        UserSession session1 = new UserSession();
        manager.addMetadata(session1, "Initial login");

        System.out.println("Active sessions: " + manager.getActiveSessionCount());

        session1 = null; // App "loses" the session object
        System.gc();
        Thread.sleep(100);

        System.out.println("Active sessions after GC: " + manager.getActiveSessionCount());
    }
}

package sets.basic.intermediate.advance;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

// This class simulates a single node in a distributed system
class IdTrackerNode {
    private final String nodeId;
    // Each node keeps track of the IDs it has seen
    private final Set<UUID> seenIds = new HashSet<>();

    public IdTrackerNode(String nodeId) {
        this.nodeId = nodeId;
    }

    // When a new ID is generated or received
    public boolean processId(UUID id) {
        if (seenIds.contains(id)) {
            System.out.println("[" + nodeId + "] Duplicate ID detected: " + id);
            return false; // ID was a duplicate
        } else {
            seenIds.add(id);
            System.out.println("[" + nodeId + "] New unique ID processed: " + id);
            return true; // ID was unique
        }
    }

    public int getUniqueIdCount() {
        return seenIds.size();
    }
}

public class DistributedUniqueIdTracker {
    public static void main(String[] args) {
        // Problem 15: Implement distributed unique ID tracker.
        // Simulation of two nodes in a distributed system
        IdTrackerNode node1 = new IdTrackerNode("Node-A");
        IdTrackerNode node2 = new IdTrackerNode("Node-B");

        // Generate a new unique ID
        UUID id1 = UUID.randomUUID();

        // Both nodes process the new ID
        node1.processId(id1);
        node2.processId(id1); // Simulates the ID being passed from one node to another

        System.out.println("\n--- Generating another ID ---");
        UUID id2 = UUID.randomUUID();
        node1.processId(id2);

        System.out.println("\n--- Simulating a duplicate ID ---");
        // Node 2 "receives" id1 again
        node2.processId(id1);

        System.out.println("\nFinal counts:");
        System.out.println("Node-A unique IDs: " + node1.getUniqueIdCount());
        System.out.println("Node-B unique IDs: " + node2.getUniqueIdCount());
    }
}

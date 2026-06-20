package functional.supplier.advance;

import java.util.function.Supplier;

// A simplified implementation of a Snowflake-like ID generator
class Snowflake {
    private static final long EPOCH = 1609459200000L; // Jan 1, 2021
    private final long nodeId;
    private long lastTimestamp = -1L;
    private long sequence = 0L;

    public Snowflake(long nodeId) {
        this.nodeId = nodeId;
    }

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();
        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) & 4095; // 4095 is 12 bits
            if (sequence == 0) {
                // Sequence overflow, wait for next millisecond
                while (timestamp <= lastTimestamp) {
                    timestamp = System.currentTimeMillis();
                }
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        return ((timestamp - EPOCH) << 22) | (nodeId << 12) | sequence;
    }
}

public class DistributedUniqueIdGenerator {
    public static void main(String[] args) {
        // Problem 15: Build distributed unique ID generator.
        
        // Create a generator for a specific node (e.g., node 5)
        Snowflake snowflake = new Snowflake(5);

        // The Supplier interface provides a clean way to get new IDs.
        Supplier<Long> idSupplier = snowflake::nextId;

        System.out.println("Generated Distributed ID: " + idSupplier.get());
        System.out.println("Generated Distributed ID: " + idSupplier.get());
    }
}

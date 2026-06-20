package stream.api.advance;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

// Simulates a remote data node
class DataNode {
    private final String nodeName;
    private final List<Integer> data;

    public DataNode(String name, List<Integer> data) { this.nodeName = name; this.data = data; }

    // Simulates a remote computation (e.g., counting even numbers)
    public CompletableFuture<Long> countEvenNumbers() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Node '" + nodeName + "' is processing...");
            return data.stream().filter(n -> n % 2 == 0).count();
        });
    }
}

public class DistributedAggregation {
    public static void main(String[] args) {
        // Problem 15: Implement distributed aggregation system (conceptual).
        
        // 1. Setup: Create simulated remote data nodes.
        List<DataNode> nodes = List.of(
                new DataNode("Node-1", List.of(1, 2, 3, 4)),
                new DataNode("Node-2", List.of(5, 6, 7, 8)),
                new DataNode("Node-3", List.of(9, 10, 11, 12))
        );

        // 2. Map Phase: Fan out the computation to all nodes in parallel.
        List<CompletableFuture<Long>> partialResults = nodes.stream()
                .map(DataNode::countEvenNumbers)
                .collect(Collectors.toList());

        // 3. Reduce Phase: Wait for all futures to complete and aggregate the final result.
        long totalEvenNumbers = partialResults.stream()
                .map(CompletableFuture::join) // Wait for each future to complete
                .reduce(0L, Long::sum);

        System.out.println("\nTotal even numbers across all nodes: " + totalEvenNumbers);
    }
}

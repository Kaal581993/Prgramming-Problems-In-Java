package functional.bifunction.biconsumer.advance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

class Request {
    String body;
    public Request(String body) { this.body = body; }
}

public class MiddlewarePipeline {
    // The BiConsumer takes the request and a mutable context map.
    private final List<BiConsumer<Request, Map<String, Object>>> pipeline = new ArrayList<>();

    public void add(BiConsumer<Request, Map<String, Object>> middleware) {
        pipeline.add(middleware);
    }

    public void execute(Request request) {
        Map<String, Object> context = new HashMap<>();
        BiConsumer<Request, Map<String, Object>> executionChain = pipeline.stream()
                .reduce(BiConsumer::andThen)
                .orElse((req, ctx) -> {});
        
        executionChain.accept(request, context);
        System.out.println("Final context: " + context);
    }

    public static void main(String[] args) {
        // Problem 13: Create middleware processing pipeline.
        MiddlewarePipeline pipeline = new MiddlewarePipeline();

        // Middleware 1: Authenticates a user and adds them to the context.
        pipeline.add((req, ctx) -> {
            System.out.println("Authenticating...");
            ctx.put("user", "authenticated_user");
        });

        // Middleware 2: Logs the request using info from the context.
        pipeline.add((req, ctx) -> {
            System.out.println("Logging request for user: " + ctx.get("user"));
        });

        pipeline.execute(new Request("GetData"));
    }
}

package functional.consumer.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

// Represents a request moving through the pipeline
class RequestContext {
    String data;
    public RequestContext(String data) { this.data = data; }
    @Override public String toString() { return "RequestContext{data='" + data + "'}"; }
}

// A middleware is a consumer that processes the context
interface Middleware extends Consumer<RequestContext> {}

public class MiddlewarePipeline {
    private final List<Middleware> pipeline = new ArrayList<>();

    public void add(Middleware middleware) {
        pipeline.add(middleware);
    }

    public void execute(RequestContext context) {
        // A simple loop is the clearest and most robust way to execute a pipeline.
        for (Middleware middleware : pipeline) {
            middleware.accept(context);
        }
    }

    public static void main(String[] args) {
        // Problem 14: Build middleware execution pipeline.
        MiddlewarePipeline pipeline = new MiddlewarePipeline();

        // Middleware 1: Logging
        pipeline.add(ctx -> System.out.println("[LOG] Processing request: " + ctx.data));

        // Middleware 2: Authentication
        pipeline.add(ctx -> System.out.println("[AUTH] Authenticating request..."));

        // Middleware 3: The final business logic
        pipeline.add(ctx -> System.out.println("[HANDLER] Executing business logic for: " + ctx.data));

        // Execute the pipeline with a new request
        pipeline.execute(new RequestContext("GetData"));
    }
}

package functional.function.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// A request object that will be transformed by the pipeline.
class Request {
    String body;
    public Request(String body) { this.body = body; }
    @Override public String toString() { return "Request{body='" + body + "'}"; }
}

// A middleware is a function that transforms a request.
interface Middleware extends Function<Request, Request> {}

public class MiddlewareTransformationSystem {
    private final List<Middleware> pipeline = new ArrayList<>();

    public void add(Middleware middleware) {
        pipeline.add(middleware);
    }

    public Request execute(Request initialRequest) {
        // Chain all middleware functions together.
        Function<Request, Request> executionChain = pipeline.stream()
                .reduce(Function.identity(), Function::andThen);
        
        return executionChain.apply(initialRequest);
    }

    public static void main(String[] args) {
        // Problem 15: Build middleware transformation system.
        MiddlewareTransformationSystem system = new MiddlewareTransformationSystem();

        // Middleware 1: Trim whitespace from the request body.
        system.add(req -> new Request(req.body.trim()));

        // Middleware 2: Encrypt the request body (simulated).
        system.add(req -> new Request("ENCRYPTED(" + req.body + ")"));

        // Middleware 3: Add a header to the request body (simulated).
        system.add(req -> new Request(req.body + " [HEADER: OK]"));

        Request initialRequest = new Request("   sensitive data   ");
        Request finalRequest = system.execute(initialRequest);

        System.out.println("Initial Request: " + initialRequest);
        System.out.println("Final Request: " + finalRequest);
    }
}

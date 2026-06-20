package functional.predicate.basic.intermediate.advance;

import java.util.Set;
import java.util.function.Predicate;

// Represents the current user making a request
class User {
    String username;
    Set<String> permissions;
    public User(String username, Set<String> permissions) {
        this.username = username; this.permissions = permissions;
    }
}

// Represents an incoming web request
class Request {
    String path;
    User user;
    public Request(String path, User user) { this.path = path; this.user = user; }
}

// The middleware component
public class AuthorizationMiddleware {
    private Predicate<Request> authorizationLogic;

    public AuthorizationMiddleware(Predicate<Request> authorizationLogic) {
        this.authorizationLogic = authorizationLogic;
    }

    public void handle(Request request) {
        System.out.println("User '" + request.user.username + "' requesting path '" + request.path + "'...");
        if (authorizationLogic.test(request)) {
            System.out.println("Access GRANTED.");
            // In a real app, this would pass the request to the next handler.
        } else {
            System.out.println("Access DENIED.");
            // In a real app, this would return a 403 Forbidden error.
        }
    }

    public static void main(String[] args) {
        // Problem 15: Build authorization middleware.

        // Define authorization rules using Predicates
        Predicate<Request> isAdmin = req -> req.user.permissions.contains("admin");
        Predicate<Request> isBillingRequest = req -> req.path.startsWith("/billing");
        Predicate<Request> hasBillingPermission = req -> req.user.permissions.contains("view_billing");

        // The final logic: Access is granted if the user is an admin,
        // OR if it's a billing request AND the user has billing permission.
        Predicate<Request> authRules = isAdmin.or(isBillingRequest.and(hasBillingPermission));

        AuthorizationMiddleware middleware = new AuthorizationMiddleware(authRules);

        // Simulate some requests
        User adminUser = new User("admin", Set.of("admin"));
        User billingUser = new User("bob", Set.of("view_billing"));
        User normalUser = new User("charlie", Set.of());

        middleware.handle(new Request("/dashboard", adminUser));      // Granted (is admin)
        middleware.handle(new Request("/billing/invoices", billingUser)); // Granted (has permission)
        middleware.handle(new Request("/billing/invoices", normalUser));  // Denied
        middleware.handle(new Request("/dashboard", normalUser));       // Denied
    }
}

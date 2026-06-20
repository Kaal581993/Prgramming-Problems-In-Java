package functional.bifunction.bipredicate.advance;

import java.util.Set;
import java.util.function.BiPredicate;

class User {
    Set<String> permissions;
    public User(Set<String> permissions) { this.permissions = permissions; }
}

class Resource {
    String requiredPermission;
    public Resource(String permission) { this.requiredPermission = permission; }
}

public class AuthorizationMiddleware {
    // This BiPredicate checks if a user has the required permission for a resource.
    private final BiPredicate<User, Resource> hasPermission = (user, resource) ->
            user.permissions.contains(resource.requiredPermission);

    public void checkAccess(User user, Resource resource) {
        System.out.println("Checking if user can access resource requiring '" + resource.requiredPermission + "'...");
        if (hasPermission.test(user, resource)) {
            System.out.println("Access GRANTED.");
        } else {
            System.out.println("Access DENIED.");
        }
    }

    public static void main(String[] args) {
        // Problem 12: Implement authorization middleware.
        AuthorizationMiddleware middleware = new AuthorizationMiddleware();

        User admin = new User(Set.of("read", "write", "delete"));
        User viewer = new User(Set.of("read"));
        
        Resource viewableResource = new Resource("read");
        Resource editableResource = new Resource("write");

        middleware.checkAccess(admin, editableResource);
        middleware.checkAccess(viewer, editableResource);
        middleware.checkAccess(viewer, viewableResource);
    }
}

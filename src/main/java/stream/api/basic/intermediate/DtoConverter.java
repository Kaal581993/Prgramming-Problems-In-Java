package stream.api.basic.intermediate;

import java.util.List;
import java.util.stream.Collectors;

// Domain Entity
class User {
    String username;
    String email;
    public User(String u, String e) { username = u; email = e; }
}

// Data Transfer Object
class UserDto {
    String username;
    public UserDto(String u) { username = u; }
    @Override public String toString() { return "UserDto{username='" + username + "'}"; }
}

public class DtoConverter {
    public static void main(String[] args) {
        // Problem 7: Convert entities to DTOs.
        List<User> users = List.of(
                new User("alice", "alice@example.com"),
                new User("bob", "bob@example.com")
        );

        // The map() operation is perfect for this transformation.
        List<UserDto> dtos = users.stream()
                .map(user -> new UserDto(user.username))
                .collect(Collectors.toList());

        System.out.println("Converted DTOs:");
        System.out.println(dtos);
    }
}

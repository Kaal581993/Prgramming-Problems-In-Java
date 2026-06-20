package functional.function.intermediate;

import java.util.function.Function;

// The domain object with potentially more data and business logic
class User {
    String username;
    String email;
    boolean isActive;
    public User(String username, String email, boolean isActive) {
        this.username = username; this.email = email; this.isActive = isActive;
    }
}

// The DTO, a simple data container for transferring data
class UserDto {
    String username;
    String email;
    public UserDto(String username, String email) {
        this.username = username; this.email = email;
    }
    @Override public String toString() { return "UserDto{username='" + username + "', email='" + email + "'}"; }
}

public class DtoMapper {
    public static void main(String[] args) {
        // Problem 6: Implement DTO mapper.
        // This function maps a User domain object to a UserDto.
        Function<User, UserDto> userToDtoMapper = user -> new UserDto(user.username, user.email);

        User user = new User("alice123", "alice@example.com", true);
        UserDto dto = userToDtoMapper.apply(user);

        System.out.println("Original User object: " + user);
        System.out.println("Mapped UserDto object: " + dto);
    }
}

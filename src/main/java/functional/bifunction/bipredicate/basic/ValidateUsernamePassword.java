package functional.bifunction.bipredicate.basic;

import java.util.function.BiPredicate;

public class ValidateUsernamePassword {
    public static void main(String[] args) {
        // Problem 3: Validate username and password.
        // A simple rule: username must be "admin" and password must be "password123".
        BiPredicate<String, String> isValidLogin = (username, password) ->
                "admin".equals(username) && "password123".equals(password);

        System.out.println("Login with admin/password123: " + isValidLogin.test("admin", "password123"));
        System.out.println("Login with user/wrongpass: " + isValidLogin.test("user", "wrongpass"));
    }
}

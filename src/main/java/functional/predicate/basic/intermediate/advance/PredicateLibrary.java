package functional.predicate.basic.intermediate.advance;

import java.util.function.Predicate;

// A utility class containing a library of reusable predicates
public final class PredicateLibrary {

    // Private constructor to prevent instantiation
    private PredicateLibrary() {}

    public static <T> Predicate<T> isNotNull() {
        return object -> object != null;
    }

    public static Predicate<String> hasLength(int length) {
        return str -> str != null && str.length() == length;
    }

    public static Predicate<Integer> isGreaterThan(int value) {
        return number -> number > value;
    }

    public static Predicate<String> contains(String substring) {
        return str -> str != null && str.contains(substring);
    }

    public static void main(String[] args) {
        // Problem 13: Create reusable Predicate library.
        Predicate<String> isValidPassword = isNotNull()
                .and(hasLength(8).or(isGreaterThan(8))) // Length is 8 or more
                .and(contains("@")); // Must contain '@'

        String pass1 = "password123@";
        String pass2 = "short@";

        System.out.println("Is '" + pass1 + "' a valid password? " + isValidPassword.test(pass1));
        System.out.println("Is '" + pass2 + "' a valid password? " + isValidPassword.test(pass2));
    }
}

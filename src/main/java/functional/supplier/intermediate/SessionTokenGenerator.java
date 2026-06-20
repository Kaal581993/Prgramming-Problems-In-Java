package functional.supplier.intermediate;

import java.util.Base64;
import java.util.UUID;
import java.util.function.Supplier;

public class SessionTokenGenerator {
    public static void main(String[] args) {
        // Problem 7: Build session token generator.
        // This supplier creates a complex, URL-safe session token.
        Supplier<String> tokenSupplier = () -> {
            UUID uuid = UUID.randomUUID();
            String token = uuid.toString() + "-" + System.currentTimeMillis();
            return Base64.getUrlEncoder().withoutPadding().encodeToString(token.getBytes());
        };

        System.out.println("Generated Session Token: " + tokenSupplier.get());
        System.out.println("Generated Session Token: " + tokenSupplier.get());
    }
}

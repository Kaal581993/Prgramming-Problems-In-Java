package functional.supplier.intermediate;

import java.security.SecureRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPasswordGenerator {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static Supplier<String> createPasswordSupplier(int length) {
        return () -> IntStream.range(0, length)
                .map(i -> RANDOM.nextInt(CHARS.length()))
                .mapToObj(CHARS::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        // Problem 10: Generate random passwords.
        Supplier<String> passwordSupplier = createPasswordSupplier(12);

        System.out.println("Generated Password: " + passwordSupplier.get());
        System.out.println("Generated Password: " + passwordSupplier.get());
    }
}

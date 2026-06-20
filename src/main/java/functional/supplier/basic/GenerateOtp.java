package functional.supplier.basic;

import java.util.Random;
import java.util.function.Supplier;

public class GenerateOtp {
    public static void main(String[] args) {
        // Problem 2: Generate OTP.
        Supplier<String> otpSupplier = () -> {
            Random random = new Random();
            // Generates a 6-digit number (100000 to 999999)
            int otp = 100000 + random.nextInt(900000);
            return String.valueOf(otp);
        };

        System.out.println("Generated OTP: " + otpSupplier.get());
        System.out.println("Generated OTP: " + otpSupplier.get());
    }
}

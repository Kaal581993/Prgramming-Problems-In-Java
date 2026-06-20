package functional.bifunction.bipredicate.intermediate;

import java.util.Map;
import java.util.function.BiPredicate;

// Simulates a service that stores valid OTPs for emails
class OtpService {
    private final Map<String, String> otpStore = Map.of("test@example.com", "123456");
    public boolean verifyOtp(String email, String otp) {
        return otp.equals(otpStore.get(email));
    }
}

public class ValidateEmailAndOtp {
    public static void main(String[] args) {
        // Problem 10: Validate email and OTP together.
        OtpService otpService = new OtpService();
        
        // The BiPredicate uses the OtpService to perform the validation.
        BiPredicate<String, String> isOtpValid = otpService::verifyOtp;

        System.out.println("Is OTP '123456' valid for 'test@example.com'? " + isOtpValid.test("test@example.com", "123456"));
        System.out.println("Is OTP '654321' valid for 'test@example.com'? " + isOtpValid.test("test@example.com", "654321"));
    }
}

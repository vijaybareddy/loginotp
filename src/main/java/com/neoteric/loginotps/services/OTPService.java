package com.neoteric.loginotps.services;

import com.neoteric.loginotps.model.OTP;
import com.neoteric.loginotps.repository.OTPRepository;
import com.neoteric.loginotps.utlis.ValidationUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OTPService {

    private final OTPRepository otpRepository;


    private SmsService smsService;//Inject SmsServices

    private static final int OTP_EXPIRY_DURATION_MINUTES = 5;

    public OTPService(OTPRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    /**
     * Generates and sends an OTP to the provided phone number.
     *
     * @param phoneNumber The phone number to which OTP is to be sent.
     * @return OTP details including OTP code and expiry date.
     * @throws Exception If any error occurs during OTP generation or sending.
     */
    @Transactional
    public OTP generateAndSendOtp(String phoneNumber) throws Exception {
        // Validate the phone number format
        if (!ValidationUtils.isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format.");
        }

        // Generate OTP
        String otpCode = generateOtpCode();

        // Set expiry date for OTP (5 minutes validity)
        LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(OTP_EXPIRY_DURATION_MINUTES);

        // Save OTP to the database
        OTP otp = new OTP();
        otp.setOtpCode(otpCode);
        otp.setPhoneNumber(phoneNumber);
        otp.setExpiryDate(expiryDate);

        OTP savedOtp = otpRepository.save(otp);

        // Send OTP via SMS (using external service like Fast2SMS)
        sendOtpViaSms(phoneNumber, otpCode);

        return savedOtp;
    }

    /**
     * Generates a 6-digit OTP code.
     *
     * @return A randomly generated 6-digit OTP code.
     */
    private String generateOtpCode() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generates a 6-digit number
        return String.valueOf(otp);
    }

    /**
     * Sends the generated OTP via SMS using an external SMS service (like Fast2SMS).
     *
     * @param phoneNumber The phone number to send OTP to.
     * @param otpCode     The OTP code to be sent.
     */
    private void sendOtpViaSms(String phoneNumber, String otpCode) {
        // Here, you would integrate with Fast2SMS or another SMS provider using their API
        // Example: Make an HTTP request to Fast2SMS API (ensure API key is valid)

        // Below is just a placeholder code. Replace it with actual integration code.
        String message = "Your OTP code is: " + otpCode;
        String apiEndpoint = "https://www.fast2sms.com/dev/bulk";

        // Use the API key and send a request to the SMS provider's endpoint
        // This could involve using RestTemplate or other HTTP libraries to send the request
        // For example, with RestTemplate or an HTTP client.

        // Uncomment and replace with actual request logic
        /*
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = apiEndpoint + "?api_key=" + apiKey + "&message=" + message + "&numbers=" + phoneNumber;
        restTemplate.getForObject(apiUrl, String.class);
        */
        System.out.println("Sending OTP: " + otpCode + " to phone number: " + phoneNumber);
    }

    /**
     * Verifies if the provided OTP matches the OTP stored for the given phone number and checks expiration.
     *
     * @param phoneNumber The phone number to verify OTP for.
     * @param otpCode     The OTP code to verify.
     * @return True if OTP is valid and not expired, false otherwise.
     */
    public boolean verifyOtp(String phoneNumber, String otpCode) {
        OTP otp = otpRepository.findTopByPhoneNumberOrderByExpiryDateDesc(phoneNumber)
                .orElseThrow(() -> new IllegalArgumentException("No OTP found for the provided phone number"));

        // Check if the OTP is expired
        if (otp.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("OTP has expired.");
        }

        // Check if the OTP code matches
        if (!otp.getOtpCode().equals(otpCode)) {
            throw new IllegalArgumentException("Invalid OTP code.");
        }

        // OTP is valid
        return true;
    }
}

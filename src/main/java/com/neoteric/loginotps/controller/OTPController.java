package com.neoteric.loginotps.controller;

import com.neoteric.loginotps.model.OTP;
import com.neoteric.loginotps.request.PhoneNumberRequest;
import com.neoteric.loginotps.services.OTPService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
public class OTPController {


    @Autowired
    private OTPService otpService;

    /**
     * API to generate and send OTP to the given phone number.
     *
//     * @param phoneNumber The phone number to which the OTP will be sent.
     * @return ResponseEntity containing the success or failure message.
     */
    @PostMapping("/send")
    @Validated
    public ResponseEntity<String> sendOtp(@Valid @RequestBody PhoneNumberRequest phoneNumberRequest) {
        try {
            if (phoneNumberRequest == null || phoneNumberRequest.getPhoneNumber()==null || phoneNumberRequest.getPhoneNumber().isEmpty()) {
                return ResponseEntity.badRequest().body("Phone number is required.");
            }

            // Generate and send OTP
            OTP otpDetails = otpService.generateAndSendOtp(phoneNumberRequest.getPhoneNumber());

            return ResponseEntity.ok("OTP sent successfully to " + otpDetails + ".");


        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to send OTP: " + e.getMessage());
        }
    }
}
    // Return success response
    //  return ResponseEntity.ok("OTP sent successfully to " + phoneNumber + ".");
    // return ResponseEntity.ok("phone"+otpDetails);
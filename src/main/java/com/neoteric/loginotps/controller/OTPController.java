package com.neoteric.loginotps.controller;


import com.neoteric.loginotps.services.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/otp"})
public class OTPController {
    private final OTPService otpService;

    @Autowired
    public OTPController(OTPService otpService) {
        this.otpService = otpService;
    }

    @PostMapping({"/sendOtp"})
    public ResponseEntity<String> sendOtp(@RequestParam String phoneNumber) {
        try {
            String response = this.otpService.sendOtp(phoneNumber);
            System.out.println(response + "response");
            return ResponseEntity.ok(response);
        } catch (Exception var3) {
            Exception e = var3;
            return ResponseEntity.badRequest().body("Failed to send OTP: " + e.getMessage());
 }
}
}
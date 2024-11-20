package com.neoteric.loginotps.request;

import lombok.Data;

@Data
public class OTPVerificationRequest {
        private String phoneNumber;
        private String otp;

    }



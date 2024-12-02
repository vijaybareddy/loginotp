package com.neoteric.loginotps.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


    @Service
    public class SmsService {



        private final String fast2smsApiKey = "your-api-key"; // Replace with your API key

        public String sendOtp(String phoneNumber, String otpCode) {
            RestTemplate restTemplate = new RestTemplate();

            // Prepare the OTP message
            String message = "Your OTP is: " + otpCode;

            // Prepare headers
            HttpHeaders headers = new HttpHeaders();
            headers.set("authorization", fast2smsApiKey);
            headers.set("Content-Type", "application/json");

            // Prepare body
            Map<String, String> body = new HashMap<>();
            body.put("sender_id", "TXIND");
            body.put("message", message);
            body.put("language", "english");
            body.put("route", "v3");
            body.put("numbers", phoneNumber);

            HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

            try {
                ResponseEntity<String> response = restTemplate.exchange(
                        "https://www.fast2sms.com/dev/bulkV2",
                        HttpMethod.POST,
                        request,
                        String.class
                );
                return response.getBody();
            } catch (Exception e) {
                e.printStackTrace();
                return "Error while sending OTP: " + e.getMessage();
            }
        }
    }



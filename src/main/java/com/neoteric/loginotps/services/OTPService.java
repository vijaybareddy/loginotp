package com.neoteric.loginotps.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
    public class OTPService {
        @Value("${fast2sms.apiKey}")
        private String apiKey;
        private final RestTemplate restTemplate;

        public OTPService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public String generateOtp() {
            int otp = (int)(Math.random() * 900000.0) + 100000;
            return String.valueOf(otp);
        }

        public String sendOtp(String phoneNumber) {
            String otpCode = this.generateOtp();
            String apiUrl = "https://www.fast2sms.com/dev/bulkV2";
            String url = UriComponentsBuilder.fromHttpUrl(apiUrl).queryParam("authorization", new Object[]{this.apiKey}).queryParam("variables_values", new Object[]{otpCode}).queryParam("route", new Object[]{"otp"}).queryParam("numbers", new Object[]{phoneNumber}).toUriString();
            HttpHeaders headers = new HttpHeaders();
            headers.set("cache-control", "no-cache");
            HttpEntity<String> entity = new HttpEntity(headers);

            try {
                ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
                return "OTP Sent Successfully: " + (String)response.getBody();
            } catch (Exception var8) {
                Exception e = var8;
                return "Failed to send OTP: " + e.getMessage();
            }
        }
    }


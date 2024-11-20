package com.neoteric.loginotps.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

public class PhoneNumberRequest {

    @NotNull(message = "Phone number cannot be null")
    @Pattern(
        regexp = "^(\\+91[- ]?)?[6789]\\d{9}$",
        message = "Invalid phone number format. Must be a valid Indian number."
    )
    private String phoneNumber;

    // Getters and setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

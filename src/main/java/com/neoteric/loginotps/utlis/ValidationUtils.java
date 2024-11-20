package com.neoteric.loginotps.utlis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^(\\+91[- ]?)?[6789]\\d{9}$");

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false; // Null or empty input is invalid
        }
        // Trim any leading or trailing spaces
        phoneNumber = phoneNumber.trim();

        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(phoneNumber);
        return matcher.matches();
    }


    public static void main(String[] args) {
        // Test cases
        String[] testNumbers = {
                "9876543210",      // Valid
                "+91 9876543210",  // Valid
                "+91-9876543210",  // Valid
                "+919876543210",   // Valid
                "0876543210",      // Invalid (starts with 0)
                "5876543210",      // Invalid (starts with 5)
                "+92 9876543210"   // Invalid (wrong country code)
        };

        for (String number : testNumbers) {
            System.out.println("Phone number: " + number + " is valid? " + isValidPhoneNumber(number));
        }
    }

}

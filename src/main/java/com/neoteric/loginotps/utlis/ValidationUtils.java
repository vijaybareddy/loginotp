package com.neoteric.loginotps.utlis;

import java.util.regex.Pattern;

public class ValidationUtils {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\d{10}$");

    /**
     * Validate a phone number (10-digit format).
     *
     * @param phoneNumber The phone number to validate.
     * @return True if valid, otherwise false.
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
    }
}

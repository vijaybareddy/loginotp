package com.neoteric.loginotps.request;

import lombok.Data;

@Data
public class OTPRequest {
    private String route;
    private String message;
    private String numbers;
    private String flash;
}
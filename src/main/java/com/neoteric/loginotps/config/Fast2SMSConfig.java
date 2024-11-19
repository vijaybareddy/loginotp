package com.neoteric.loginotps.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration

public class Fast2SMSConfig {
    @Value("${fast2sms.api-key}")
    private String apiKey;

    public Fast2SMSConfig() {

    }
    public String getApiKey(){
        return this.apiKey;
    }
}

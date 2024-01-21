package com.org.ecommerce.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.stripe")
public class StripeConfig {
    private String secretKey;
    private String publicKey;
    
    public String getSecretKey() {
        return secretKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

}

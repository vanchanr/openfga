package com.example.openfga.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "openfga")
@Data
public class OpenFgaConfig {
    
    private String serverUrl;
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
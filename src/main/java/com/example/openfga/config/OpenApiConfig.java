package com.example.openfga.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("OpenFGA API Proxy")
                        .version("1.0.0")
                        .description("Spring Boot application that proxies the OpenFGA API")
                        .license(new License().name("MIT")));
    }
}
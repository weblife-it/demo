package com.demo.programmazione;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Consenti CORS su tutti gli endpoint
                        .allowedOrigins("http://localhost:4200") // Origine consentita (Angular)
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*") 
                        .allowCredentials(true); // Consenti credenziali (cookie, token, ecc.)
            }
        };
    }
}
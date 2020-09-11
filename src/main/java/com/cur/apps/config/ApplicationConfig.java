package com.cur.apps.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConfig {

    @Value("${property.environemt}")
    private String env;


    @PostConstruct
    private void init() {
        System.out.println("\n \n \n ENV VAL " + env + "\n \n \n");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/rest")
                        .allowedOrigins("http://localhost8000");
            }
        };

    }
}

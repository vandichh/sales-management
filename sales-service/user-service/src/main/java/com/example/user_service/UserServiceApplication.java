package com.example.user_service;

import com.example.common.SharedAutoConfiguration;
import com.example.common.config.ApplicationConfig;
import com.example.common.config.OpenTelemetryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SharedAutoConfiguration.class,
        ApplicationConfig.class,
        OpenTelemetryConfig.class})
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}

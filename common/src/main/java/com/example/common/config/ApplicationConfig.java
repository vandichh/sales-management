package com.example.common.config;

import com.example.common.logging.ApiAccessLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ApiAccessLoggingFilter loggingFilter() {
        return new ApiAccessLoggingFilter();
    }
}

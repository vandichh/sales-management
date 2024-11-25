package com.example.sales_application.config;

import com.example.sales_application.adaptor.RestTemplateLoggingInterceptor;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplateCustomizer restTemplateCustomizer() {
        return (restTemplate) ->
                restTemplate.getInterceptors().add(new RestTemplateLoggingInterceptor(0));
    }
}

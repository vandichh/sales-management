package com.example.sale_server.config;

import com.example.sale_server.adaptor.RestTemplateLoggingInterceptor;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {
    @Bean
    public RestTemplateCustomizer restTemplateCustomizer() {
        return (restTemplate) ->
                restTemplate.getInterceptors().add(new RestTemplateLoggingInterceptor(0));
    }
}

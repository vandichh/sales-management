package com.example.sales_application.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "saleserver.order-service")
@RequiredArgsConstructor
public class OrderServiceApiProperties {
    public final String baseUrl;
}

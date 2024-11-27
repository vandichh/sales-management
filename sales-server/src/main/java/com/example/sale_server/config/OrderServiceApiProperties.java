package com.example.sale_server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "saleserver.order-service")
@RequiredArgsConstructor
public class OrderServiceApiProperties {
    public final String baseUrl;
}

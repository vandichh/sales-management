package com.example.sales_application.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "saleserver.product-service")
@RequiredArgsConstructor
public class ProductServiceApiProperties {
    public final String baseUrl;
}

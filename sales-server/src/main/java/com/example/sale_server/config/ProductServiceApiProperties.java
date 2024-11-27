package com.example.sale_server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "saleserver.product-service")
@RequiredArgsConstructor
public class ProductServiceApiProperties {
    public final String baseUrl;
}

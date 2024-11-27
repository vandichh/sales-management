package com.example.sale_server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "saleserver.user-service")
@RequiredArgsConstructor
public class UserServiceApiProperties {
    public final String baseUrl;
}

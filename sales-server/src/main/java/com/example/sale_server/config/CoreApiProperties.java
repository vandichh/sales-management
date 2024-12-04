package com.example.sale_server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "saleserver.core")
@RequiredArgsConstructor
public class CoreApiProperties {
    public final String baseUrl;
}

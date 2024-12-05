package com.example.sales_core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "params.datasource")
@RequiredArgsConstructor
public class DataSourceProperties {
    public final String url;
    public final String username;
    public final String password;
}

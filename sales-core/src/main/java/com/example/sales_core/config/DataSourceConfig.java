package com.example.sales_core.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.opentelemetry.instrumentation.jdbc.datasource.OpenTelemetryDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(DataSourceProperties properties) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(properties.url);
        hikariConfig.setUsername(properties.username);
        hikariConfig.setPassword(properties.password);

        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        return new OpenTelemetryDataSource(hikariDataSource);
    }
}

package com.example.sales_core.config;

import io.opentelemetry.instrumentation.jdbc.datasource.OpenTelemetryDataSource;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(DataSourceProperties properties) {
        PGSimpleDataSource pgDataSource = new PGSimpleDataSource();
        pgDataSource.setURL(properties.url);
        pgDataSource.setUser(properties.username);
        pgDataSource.setPassword(properties.password);
        return new OpenTelemetryDataSource(pgDataSource);
    }
}

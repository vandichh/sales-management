package com.example.sales_core;

import com.example.common.config.ApplicationConfig;
import com.example.common.config.OpenTelemetryConfig;
import com.example.common.config.SharedAutoConfiguration;
import com.example.sales_core.config.DataSourceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableConfigurationProperties({DataSourceProperties.class})
@Import({SharedAutoConfiguration.class,
        ApplicationConfig.class,
        OpenTelemetryConfig.class})
public class SalesCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesCoreApplication.class, args);
    }

}

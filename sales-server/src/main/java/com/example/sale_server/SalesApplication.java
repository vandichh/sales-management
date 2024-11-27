package com.example.sale_server;

import com.example.common.SharedAutoConfiguration;
import com.example.common.config.ApplicationConfig;
import com.example.common.config.OpenTelemetryConfig;
import com.example.sale_server.config.OrderServiceApiProperties;
import com.example.sale_server.config.ProductServiceApiProperties;
import com.example.sale_server.config.SaleServerApplicationProperties;
import com.example.sale_server.config.UserServiceApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableConfigurationProperties({
        SaleServerApplicationProperties.class,
        OrderServiceApiProperties.class,
        ProductServiceApiProperties.class,
        UserServiceApiProperties.class
})
@Import({ApplicationConfig.class,
        OpenTelemetryConfig.class,
        SharedAutoConfiguration.class})
public class SalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }

}

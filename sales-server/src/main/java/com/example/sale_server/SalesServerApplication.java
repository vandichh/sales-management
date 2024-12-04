package com.example.sale_server;

import com.example.common.config.ApplicationConfig;
import com.example.common.config.OpenTelemetryConfig;
import com.example.common.config.SharedAutoConfiguration;
import com.example.sale_server.config.CoreApiProperties;
import com.example.sale_server.config.SaleServerApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableConfigurationProperties({
        SaleServerApplicationProperties.class,
        CoreApiProperties.class
})
@Import({ApplicationConfig.class,
        OpenTelemetryConfig.class,
        SharedAutoConfiguration.class})
public class SalesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesServerApplication.class, args);
    }

}

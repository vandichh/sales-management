package com.example.sales_application;

import com.example.sales_application.config.OrderServiceApiProperties;
import com.example.sales_application.config.ProductServiceApiProperties;
import com.example.sales_application.config.SaleServerApplicationProperties;
import com.example.sales_application.config.UserServiceApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        SaleServerApplicationProperties.class,
        OrderServiceApiProperties.class,
        ProductServiceApiProperties.class,
        UserServiceApiProperties.class
})
public class SalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }

}

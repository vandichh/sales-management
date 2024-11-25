package com.example.sales_application.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "saleserver")
@RequiredArgsConstructor
@Builder
public class SaleServerApplicationProperties {
    public final HttpConnectionProperty httpConnection;

    @AllArgsConstructor
    @ToString
    public static class HttpConnectionProperty {

        public final Integer maxPerRoute;

        public final Integer maxTotal;
    }
}

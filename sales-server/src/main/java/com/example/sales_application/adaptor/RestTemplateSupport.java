package com.example.sales_application.adaptor;

import com.example.sales_application.config.SaleServerApplicationProperties;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RestTemplateSupport {
    private static final ResponseErrorHandler ERROR_HANDLER = initErrorHandler();

    private final RestTemplateBuilder builder;

    public RestTemplateSupport(RestTemplateBuilder restBuilder, SaleServerApplicationProperties properties) {
        ClientHttpRequestFactory requestFactory = initFactorySupplier(properties);
        this.builder = restBuilder
                .requestFactory(() -> requestFactory)
                .errorHandler(ERROR_HANDLER);
    }

    private static ClientHttpRequestFactory initFactorySupplier(SaleServerApplicationProperties properties) {
        PoolingHttpClientConnectionManager poolManager = new PoolingHttpClientConnectionManager();
        poolManager.setMaxTotal(properties.httpConnection.maxTotal);
        poolManager.setDefaultMaxPerRoute(properties.httpConnection.maxPerRoute);

        HttpClient client = HttpClients.custom().setConnectionManager(poolManager).build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }

    private static ResponseErrorHandler initErrorHandler() {
        return new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) {
                // Don't throw Exception.
            }
        };
    }

    public RestTemplateBuilder builder() {
        return this.builder;
    }
}

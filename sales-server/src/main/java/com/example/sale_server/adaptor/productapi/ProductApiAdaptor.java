package com.example.sale_server.adaptor.productapi;

import com.example.sale_server.domain.value.Either;
import com.example.sale_server.domain.value.product.ProductApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductApiAdaptor implements ProductApi {
    private final ProductApiAdaptorSupport support;

    @Override
    public void healthCheck() {
        RequestEntity<Void> request = this.support.initGet("/health-check").build();
        this.support.execute(request, Void.class);
    }
}

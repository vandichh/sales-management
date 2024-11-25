package com.example.sales_application.adaptor.productapi;

import com.example.sales_application.domain.value.product.ProductApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductApiAdaptor implements ProductApi {
    private final ProductApiAdaptorSupport support;
}

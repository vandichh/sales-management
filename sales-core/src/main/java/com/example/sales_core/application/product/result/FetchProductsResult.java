package com.example.sales_core.application.product.result;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchProductsResult {
    public final List<FindProductResult> products;

    public static FetchProductsResult create() {

        return FetchProductsResult.builder()
                .build();
    }
}

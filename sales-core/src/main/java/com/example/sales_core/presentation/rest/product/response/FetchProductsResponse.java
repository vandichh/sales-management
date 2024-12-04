package com.example.sales_core.presentation.rest.product.response;

import com.example.sales_core.application.product.result.FetchProductsResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchProductsResponse {
    public final int total;
    public final List<FindProductResponse> products;

    public static FetchProductsResponse create(FetchProductsResult fetchProductsResult) {
        List<FindProductResponse> products = fetchProductsResult.products.stream().map(FindProductResponse::create).toList();
        return FetchProductsResponse.builder()
                .products(products)
                .build();
    }
}

package com.example.sale_server.presentation.rest.product.response;

import com.example.sale_server.application.product.result.FetchProductsResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchProductsResponse {
    public final int total;
    public final List<FindProductResponse> products;

    public static FetchProductsResponse initResponse(FetchProductsResult fetchProductsResult) {
        List<FindProductResponse> productResults = fetchProductsResult.products.stream()
                .map(FindProductResponse::initResponse).toList();

        return FetchProductsResponse.builder()
                .products(productResults)
                .total(productResults.size())
                .build();
    }
}

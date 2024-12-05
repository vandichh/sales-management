package com.example.sale_server.application.product.result;

import com.example.sale_server.domain.coreapi.result.product.CoreApiFetchProductsResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchProductsResult {
    public final List<FindProductResult> products;

    public static FetchProductsResult initResult(CoreApiFetchProductsResult coreApiFetchProductsResult) {
        List<FindProductResult> productResults = coreApiFetchProductsResult.products.stream()
                .map(FindProductResult::initResult).toList();

        return FetchProductsResult.builder()
                .products(productResults)
                .build();
    }
}

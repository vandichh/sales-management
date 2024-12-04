package com.example.sale_server.adaptor.coreapi.response.product;

import com.example.sale_server.domain.coreapi.result.product.CoreApiFetchProductsResult;
import com.example.sale_server.domain.coreapi.result.product.CoreApiFindProductResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CoreApiFetchProductsResponse {
    public final List<CoreApiFindProductResponse> products;

    public CoreApiFetchProductsResult toResult() {
        List<CoreApiFindProductResult> productResults = this.products.stream()
                .map(CoreApiFindProductResponse::toResult).collect(Collectors.toList());

        return CoreApiFetchProductsResult.builder()
                .products(productResults)
                .build();
    }
}

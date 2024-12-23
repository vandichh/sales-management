package com.example.sales_core.application.product.result;

import com.example.sales_core.domain.entity.product.ProductEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchProductsResult {
    public final List<FindProductResult> products;

    public static FetchProductsResult initResult(List<ProductEntity> productEntities) {
        List<FindProductResult> products = productEntities.stream().map(FindProductResult::initResult).toList();
        return FetchProductsResult.builder()
                .products(products)
                .build();
    }
}

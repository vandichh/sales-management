package com.example.sales_core.presentation.rest.product.response;

import com.example.sales_core.application.product.result.FindProductResult;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindProductResponse {
    public final int productId;
    public final String name;
    public final String description;
    public final double price;
    public final int quantity;

    public static FindProductResponse initResponse(FindProductResult findProductResult) {
        return FindProductResponse.builder()
                .productId(findProductResult.getProductId())
                .name(findProductResult.getName())
                .description(findProductResult.getDescription())
                .price(findProductResult.getPrice())
                .quantity(findProductResult.getQuantity())
                .build();
    }
}

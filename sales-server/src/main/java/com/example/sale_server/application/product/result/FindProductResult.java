package com.example.sale_server.application.product.result;

import com.example.sale_server.domain.coreapi.result.product.CoreApiFindProductResult;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindProductResult {
    public final int productId;
    public final String name;
    public final String description;
    public final double price;
    public final int quantity;

    public static FindProductResult initResult(CoreApiFindProductResult coreApiFindProductResult) {
        return FindProductResult.builder()
                .productId(coreApiFindProductResult.getProductId())
                .name(coreApiFindProductResult.getName())
                .description(coreApiFindProductResult.getDescription())
                .price(coreApiFindProductResult.getPrice())
                .quantity(coreApiFindProductResult.getQuantity())
                .build();
    }
}

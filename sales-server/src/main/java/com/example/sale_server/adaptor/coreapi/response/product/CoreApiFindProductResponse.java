package com.example.sale_server.adaptor.coreapi.response.product;

import com.example.sale_server.domain.coreapi.result.product.CoreApiFindProductResult;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoreApiFindProductResponse {
    public final int productId;
    public final String name;
    public final String description;
    public final double price;
    public final int quantity;

    public CoreApiFindProductResult toResult() {
        return CoreApiFindProductResult.builder()
                .productId(this.productId)
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .quantity(this.quantity)
                .build();
    }
}

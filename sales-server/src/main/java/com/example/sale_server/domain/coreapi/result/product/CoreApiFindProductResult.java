package com.example.sale_server.domain.coreapi.result.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoreApiFindProductResult {
    public final int productId;
    public final String name;
    public final String description;
    public final double price;
    public final int quantity;
}

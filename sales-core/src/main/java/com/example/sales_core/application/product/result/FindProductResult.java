package com.example.sales_core.application.product.result;

import com.example.sales_core.domain.entity.product.ProductEntity;
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

    public static FindProductResult create(ProductEntity productEntity) {
        return FindProductResult.builder()
                .productId(productEntity.getProductId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .build();
    }
}

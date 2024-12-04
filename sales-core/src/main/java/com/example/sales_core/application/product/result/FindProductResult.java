package com.example.sales_core.application.product.result;

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

    public static FindProductResult create() {
        return FindProductResult.builder().build();
    }
}

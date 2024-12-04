package com.example.sale_server.domain.product.result;

import lombok.Data;

@Data
public class ProductResult {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int quantity;
}

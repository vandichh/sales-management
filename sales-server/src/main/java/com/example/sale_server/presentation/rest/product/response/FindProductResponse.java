package com.example.sale_server.presentation.rest.product.response;

import lombok.Data;

@Data
public class FindProductResponse {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int quantity;
}

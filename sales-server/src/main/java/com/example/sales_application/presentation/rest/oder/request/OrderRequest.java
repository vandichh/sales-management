package com.example.sales_application.presentation.rest.oder.request;

import lombok.Data;

@Data
public class OrderRequest {
    private String userId;
    private String productId;
}

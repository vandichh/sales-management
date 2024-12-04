package com.example.product_service.presentation.rest;

import com.example.product_service.application.ProductApplication;
import com.example.product_service.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductResource {
    private final ProductApplication productApplication;

    @GetMapping("")
    public List<Product> getProducts() {
        return productApplication.getAllProducts();
    }
}

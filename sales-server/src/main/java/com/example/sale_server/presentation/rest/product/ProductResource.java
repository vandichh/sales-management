package com.example.sale_server.presentation.rest.product;

import com.example.sale_server.application.product.ProductApplication;
import com.example.sale_server.presentation.rest.product.response.FetchProductsResponse;
import com.example.sale_server.presentation.rest.product.response.FindProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductResource {
    private final ProductApplication productApplication;

    @GetMapping("")
    public FetchProductsResponse fetchProducts() {
        return FetchProductsResponse.initResponse(productApplication.fetchProducts());
    }

    @GetMapping("/{productId}")
    public FindProductResponse fetchProducts(@PathVariable int productId) {
        return FindProductResponse.initResponse(productApplication.findProduct(productId));
    }
}

package com.example.sales_core.presentation.rest.product;

import com.example.sales_core.application.product.ProductApplication;
import com.example.sales_core.presentation.rest.order.resopnse.FindOrderResponse;
import com.example.sales_core.presentation.rest.product.response.FetchProductsResponse;
import com.example.sales_core.presentation.rest.product.response.FindProductResponse;
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

    @GetMapping("/{id}")
    public FindProductResponse findProduct(@PathVariable int id) {
        return FindProductResponse.initResponse(productApplication.findProduct(id));
    }
}

package com.example.sales_core.application.product;

import com.example.sales_core.application.product.result.FetchProductsResult;
import com.example.sales_core.application.product.result.FindProductResult;
import com.example.sales_core.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductApplication {
    private final ProductRepository productRepository;

    public FetchProductsResult fetchProducts() {
        return FetchProductsResult.initResult(productRepository.findAll());
    }

    public FindProductResult findProduct(int id) {
        return FindProductResult.initResult(productRepository.findById(id));
    }
}

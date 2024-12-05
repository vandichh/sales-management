package com.example.sales_core.domain.repository;

import com.example.sales_core.domain.entity.product.ProductEntity;

import java.util.List;

public interface ProductRepository {
    List<ProductEntity> findAll();
}

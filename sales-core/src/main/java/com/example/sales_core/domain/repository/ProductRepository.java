package com.example.sales_core.domain.repository;

import com.example.sales_core.domain.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}

package com.example.sales_core.adaptor.db.dao;

import com.example.sales_core.domain.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepositoryDao extends JpaRepository<ProductEntity, Long> {
}

package com.example.sales_core.adaptor.db;

import com.example.sales_core.adaptor.db.dao.ProductRepositoryDao;
import com.example.sales_core.domain.entity.product.ProductEntity;
import com.example.sales_core.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaProductRepository implements ProductRepository {
    private final ProductRepositoryDao productRepositoryDao;

    @Override
    public List<ProductEntity> findAll() {
        return productRepositoryDao.findAll();
    }
}

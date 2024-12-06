package com.example.sales_core.adaptor.db;

import com.example.sales_core.adaptor.db.dao.ProductRepositoryDao;
import com.example.sales_core.domain.entity.product.ProductEntity;
import com.example.sales_core.domain.exception.ResourceNotFoundException;
import com.example.sales_core.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaProductRepository implements ProductRepository {
    private final ProductRepositoryDao productRepositoryDao;

    @Override
    public List<ProductEntity> findAll() {
        return productRepositoryDao.findAll();
    }

    @Override
    public ProductEntity findById(int id) {
        Optional<ProductEntity> optionalProductEntity = productRepositoryDao.findById(id);
        if (optionalProductEntity.isEmpty()) {
            throw new ResourceNotFoundException("Product not found");
        }
        return optionalProductEntity.get();
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return productRepositoryDao.save(product);
    }
}

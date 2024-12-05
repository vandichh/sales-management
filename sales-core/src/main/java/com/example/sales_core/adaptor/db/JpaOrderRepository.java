package com.example.sales_core.adaptor.db;

import com.example.sales_core.adaptor.db.dao.OrderRepositoryDao;
import com.example.sales_core.domain.entity.order.OrderEntity;
import com.example.sales_core.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaOrderRepository implements OrderRepository {
    private final OrderRepositoryDao orderRepositoryDao;

    @Override
    public List<OrderEntity> findAll() {
        return orderRepositoryDao.findAll();
    }
}

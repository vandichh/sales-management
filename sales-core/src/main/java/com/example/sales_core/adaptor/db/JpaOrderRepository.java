package com.example.sales_core.adaptor.db;

import com.example.sales_core.adaptor.db.dao.OrderRepositoryDao;
import com.example.sales_core.domain.entity.order.OrderEntity;
import com.example.sales_core.domain.exception.ResourceNotFoundException;
import com.example.sales_core.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaOrderRepository implements OrderRepository {
    private final OrderRepositoryDao orderRepositoryDao;

    @Override
    public List<OrderEntity> findAll() {
        return orderRepositoryDao.findAll();
    }

    @Override
    public OrderEntity findById(int id) {
        Optional<OrderEntity> optionalOrderEntity = orderRepositoryDao.findById(id);
        if (optionalOrderEntity.isEmpty()) {
            throw new ResourceNotFoundException("Order not found");
        }
        return optionalOrderEntity.get();
    }

    @Override
    public OrderEntity save(OrderEntity order) {
        return orderRepositoryDao.save(order);
    }
}

package com.example.sales_core.domain.repository;

import com.example.sales_core.domain.entity.order.OrderEntity;

import java.util.List;

public interface OrderRepository {
    List<OrderEntity> findAll();

    OrderEntity findById(int id);

    OrderEntity save(OrderEntity order);

    void update(String orderId);
}

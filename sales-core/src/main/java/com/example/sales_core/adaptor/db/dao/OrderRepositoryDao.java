package com.example.sales_core.adaptor.db.dao;

import com.example.sales_core.domain.entity.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderRepositoryDao extends JpaRepository<OrderEntity, Long> {
}

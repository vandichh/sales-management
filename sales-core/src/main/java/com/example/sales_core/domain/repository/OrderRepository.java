package com.example.sales_core.domain.repository;

import com.example.sales_core.domain.entity.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}

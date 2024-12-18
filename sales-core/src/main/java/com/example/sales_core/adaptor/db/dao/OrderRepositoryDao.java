package com.example.sales_core.adaptor.db.dao;

import com.example.sales_core.domain.entity.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface OrderRepositoryDao extends JpaRepository<OrderEntity, Integer> {
    @Modifying
    @Query("UPDATE OrderEntity o SET o.status = :status WHERE o.orderId = :userId")
    void updateUserName(@Param("orderId") String orderId, @Param("status") String status);
}

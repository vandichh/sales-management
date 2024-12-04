package com.example.sales_core.domain.entity.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    public int orderId;

    @Column(name = "user_id")
    public String userId;

    @Column(name = "total_amount")
    public int totalAmount;

    @Column(name = "order_date")
    public LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    public List<OrderItemEntity> items;
}

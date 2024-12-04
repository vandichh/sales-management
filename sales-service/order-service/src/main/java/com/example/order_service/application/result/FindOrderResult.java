package com.example.order_service.application.result;

import com.example.order_service.domain.entity.OrderEntity;
import com.example.order_service.domain.entity.OrderItemEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class FindOrderResult {
    public final int orderId;
    public final String userId;
    public final int totalAmount;
    public final LocalDateTime orderDate;
    public final String status;
    public final List<OrderItem> items;

    @Data
    @Builder
    public static class OrderItem {
        public final int orderItemId;
        public final int productId;
        public final int quantity;
        public final double price;

        public static OrderItem create(OrderItemEntity orderItem) {
            return OrderItem.builder()
                    .orderItemId(orderItem.orderItemId)
                    .productId(orderItem.productId)
                    .quantity(orderItem.quantity)
                    .price(orderItem.price)
                    .build();
        }
    }

    public static FindOrderResult create(OrderEntity orderEntity) {
        List<OrderItem> orderItems = orderEntity.items.stream().map(OrderItem::create).toList();

        return FindOrderResult.builder()
                .orderId(orderEntity.orderId)
                .userId(orderEntity.userId)
                .totalAmount(orderEntity.totalAmount)
                .orderDate(orderEntity.orderDate)
                .status(orderEntity.status.name())
                .items(orderItems)
                .build();
    }
}

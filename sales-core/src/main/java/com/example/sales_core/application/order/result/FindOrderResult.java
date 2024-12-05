package com.example.sales_core.application.order.result;

import com.example.sales_core.domain.entity.order.OrderEntity;
import com.example.sales_core.domain.entity.order.OrderItemEntity;
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

    public static FindOrderResult initResult(OrderEntity orderEntity) {
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
}

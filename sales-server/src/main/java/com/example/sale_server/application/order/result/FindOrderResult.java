package com.example.sale_server.application.order.result;

import com.example.sale_server.domain.order.result.OrderApiFindOrderResult;
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

        public static OrderItem create(OrderApiFindOrderResult.OrderItem orderItem) {
            return OrderItem.builder()
                    .orderItemId(orderItem.orderItemId)
                    .productId(orderItem.productId)
                    .quantity(orderItem.quantity)
                    .price(orderItem.price)
                    .build();
        }
    }

    public static FindOrderResult create(OrderApiFindOrderResult orderApiFindOrderResult) {
        List<OrderItem> orderItems = orderApiFindOrderResult.items.stream().map(OrderItem::create).toList();

        return FindOrderResult.builder()
                .orderId(orderApiFindOrderResult.orderId)
                .userId(orderApiFindOrderResult.userId)
                .totalAmount(orderApiFindOrderResult.totalAmount)
                .orderDate(orderApiFindOrderResult.orderDate)
                .status(orderApiFindOrderResult.status)
                .items(orderItems)
                .build();
    }
}
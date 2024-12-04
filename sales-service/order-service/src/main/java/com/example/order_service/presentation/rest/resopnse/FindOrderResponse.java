package com.example.order_service.presentation.rest.resopnse;

import com.example.order_service.application.result.FindOrderResult;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class FindOrderResponse {
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

        public static OrderItem create(FindOrderResult.OrderItem orderItem) {
            return OrderItem.builder()
                    .orderItemId(orderItem.orderItemId)
                    .productId(orderItem.productId)
                    .quantity(orderItem.quantity)
                    .price(orderItem.price)
                    .build();
        }
    }

    public static FindOrderResponse create(FindOrderResult findOrderResult) {
        List<OrderItem> orderItems = findOrderResult.items.stream().map(OrderItem::create).toList();

        return FindOrderResponse.builder()
                .orderId(findOrderResult.orderId)
                .userId(findOrderResult.userId)
                .totalAmount(findOrderResult.totalAmount)
                .orderDate(findOrderResult.orderDate)
                .status(findOrderResult.status)
                .items(orderItems)
                .build();
    }
}

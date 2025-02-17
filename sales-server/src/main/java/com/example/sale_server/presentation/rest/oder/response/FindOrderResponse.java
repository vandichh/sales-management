package com.example.sale_server.presentation.rest.oder.response;

import com.example.sale_server.application.order.result.FindOrderResult;
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

    public static FindOrderResponse initResponse(FindOrderResult findOrderResult) {
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
}

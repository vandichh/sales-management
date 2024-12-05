package com.example.sale_server.application.order.result;

import com.example.sale_server.domain.coreapi.result.order.CoreApiFindOrderResult;
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

    public static FindOrderResult initResult(CoreApiFindOrderResult coreApiFindOrderResult) {
        List<OrderItem> orderItems = coreApiFindOrderResult.items.stream().map(OrderItem::create).toList();

        return FindOrderResult.builder()
                .orderId(coreApiFindOrderResult.orderId)
                .userId(coreApiFindOrderResult.userId)
                .totalAmount(coreApiFindOrderResult.totalAmount)
                .orderDate(coreApiFindOrderResult.orderDate)
                .status(coreApiFindOrderResult.status)
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

        public static OrderItem create(CoreApiFindOrderResult.OrderItem orderItem) {
            return OrderItem.builder()
                    .orderItemId(orderItem.orderItemId)
                    .productId(orderItem.productId)
                    .quantity(orderItem.quantity)
                    .price(orderItem.price)
                    .build();
        }
    }
}

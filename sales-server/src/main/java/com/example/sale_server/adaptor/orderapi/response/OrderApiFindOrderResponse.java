package com.example.sale_server.adaptor.orderapi.response;

import com.example.sale_server.domain.order.result.OrderApiFindOrderResult;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderApiFindOrderResponse {
    public final int orderId;
    public final String userId;
    public final int totalAmount;
    public final LocalDateTime orderDate;
    public final String status;
    public final List<OrderItem> items;

    public OrderApiFindOrderResult toResult() {
        List<OrderApiFindOrderResult.OrderItem> orderItems = this.items.stream().map(OrderItem::toOrderItem).toList();

        return OrderApiFindOrderResult.builder()
                .orderId(this.orderId)
                .userId(this.userId)
                .totalAmount(this.totalAmount)
                .orderDate(this.orderDate)
                .status(this.status)
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

        public OrderApiFindOrderResult.OrderItem toOrderItem() {
            return OrderApiFindOrderResult.OrderItem.builder()
                    .orderItemId(orderItemId)
                    .productId(productId)
                    .quantity(quantity)
                    .price(price)
                    .build();
        }
    }
}

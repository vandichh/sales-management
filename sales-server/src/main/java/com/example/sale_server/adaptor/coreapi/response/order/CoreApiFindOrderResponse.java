package com.example.sale_server.adaptor.coreapi.response.order;

import com.example.sale_server.domain.coreapi.result.order.CoreApiFindOrderResult;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CoreApiFindOrderResponse {
    public final int orderId;
    public final String userId;
    public final int totalAmount;
    public final LocalDateTime orderDate;
    public final String status;
    public final List<OrderItem> items;

    public CoreApiFindOrderResult toResult() {
        List<CoreApiFindOrderResult.OrderItem> orderItems = this.items.stream().map(OrderItem::toOrderItem).toList();

        return CoreApiFindOrderResult.builder()
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

        public CoreApiFindOrderResult.OrderItem toOrderItem() {
            return CoreApiFindOrderResult.OrderItem.builder()
                    .orderItemId(this.orderItemId)
                    .productId(this.productId)
                    .quantity(this.quantity)
                    .price(this.price)
                    .build();
        }
    }
}

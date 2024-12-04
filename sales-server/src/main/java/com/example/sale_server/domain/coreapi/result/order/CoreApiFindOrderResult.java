package com.example.sale_server.domain.coreapi.result.order;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CoreApiFindOrderResult {
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
    }
}

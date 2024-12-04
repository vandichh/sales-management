package com.example.sale_server.adaptor.orderapi.response;

import com.example.sale_server.domain.order.result.OrderApiFetchOrdersResult;
import com.example.sale_server.domain.order.result.OrderApiFindOrderResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderApiFetchOrdersResponse {
    public final List<OrderApiFindOrderResponse> orders;

    public OrderApiFetchOrdersResult toResult() {
        List<OrderApiFindOrderResult> orderResults = this.orders.stream().map(OrderApiFindOrderResponse::toResult).toList();

        return OrderApiFetchOrdersResult.builder()
                .orders(orderResults)
                .build();
    }
}

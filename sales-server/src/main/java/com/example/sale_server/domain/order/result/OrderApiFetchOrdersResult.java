package com.example.sale_server.domain.order.result;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderApiFetchOrdersResult {
    public final List<OrderApiFindOrderResult> orders;
}

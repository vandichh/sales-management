package com.example.sale_server.application.order.result;

import com.example.sale_server.domain.order.result.OrderApiFetchOrdersResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchOrdersResult {
    public final List<FindOrderResult> orderResults;

    public static FetchOrdersResult create(OrderApiFetchOrdersResult orderApiFetchOrdersResult) {
        List<FindOrderResult> orderResultList = orderApiFetchOrdersResult.orders.stream().map(FindOrderResult::create).toList();

        return FetchOrdersResult.builder()
                .orderResults(orderResultList)
                .build();
    }
}

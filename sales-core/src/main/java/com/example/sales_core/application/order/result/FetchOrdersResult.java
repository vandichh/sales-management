package com.example.sales_core.application.order.result;

import com.example.sales_core.domain.entity.order.OrderEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchOrdersResult {
    public final List<FindOrderResult> orderResults;

    public static FetchOrdersResult initResult(List<OrderEntity> orderEntities) {
        List<FindOrderResult> orderResultList = orderEntities.stream().map(FindOrderResult::initResult).toList();

        return FetchOrdersResult.builder()
                .orderResults(orderResultList)
                .build();
    }
}

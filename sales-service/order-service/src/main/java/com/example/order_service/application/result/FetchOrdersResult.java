package com.example.order_service.application.result;

import com.example.order_service.domain.entity.OrderEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchOrdersResult {
    public final List<FindOrderResult> orderResults;

    public static FetchOrdersResult create(List<OrderEntity> orderEntities) {
        List<FindOrderResult> orderResultList = orderEntities.stream().map(FindOrderResult::create).toList();

        return FetchOrdersResult.builder()
                .orderResults(orderResultList)
                .build();
    }
}

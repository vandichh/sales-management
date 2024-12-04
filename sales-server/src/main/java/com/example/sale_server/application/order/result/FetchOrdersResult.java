package com.example.sale_server.application.order.result;

import com.example.sale_server.domain.coreapi.result.order.CoreApiFetchOrdersResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchOrdersResult {
    public final List<FindOrderResult> orderResults;

    public static FetchOrdersResult create(CoreApiFetchOrdersResult coreApiFetchOrdersResult) {
        List<FindOrderResult> orderResultList = coreApiFetchOrdersResult.orders.stream().map(FindOrderResult::create).toList();

        return FetchOrdersResult.builder()
                .orderResults(orderResultList)
                .build();
    }
}

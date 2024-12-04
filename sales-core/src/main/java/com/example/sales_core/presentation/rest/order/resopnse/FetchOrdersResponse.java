package com.example.sales_core.presentation.rest.order.resopnse;

import com.example.sales_core.application.order.result.FetchOrdersResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchOrdersResponse {
    public final List<FindOrderResponse> orders;

    public static FetchOrdersResponse create(FetchOrdersResult fetchOrdersResult) {
        List<FindOrderResponse> orders = fetchOrdersResult.orderResults.stream().map(FindOrderResponse::create).toList();

        return FetchOrdersResponse.builder()
                .orders(orders)
                .build();
    }
}

package com.example.order_service.presentation.rest.resopnse;

import com.example.order_service.application.result.FetchOrdersResult;
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

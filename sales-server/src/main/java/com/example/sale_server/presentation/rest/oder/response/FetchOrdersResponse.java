package com.example.sale_server.presentation.rest.oder.response;

import com.example.sale_server.application.order.result.FetchOrdersResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchOrdersResponse {
    List<FindOrderResponse> orders;

    public static FetchOrdersResponse create(FetchOrdersResult fetchOrdersResult) {
        List<FindOrderResponse> findOrderResults = fetchOrdersResult.orderResults.stream().map(FindOrderResponse::create).toList();

        return FetchOrdersResponse.builder()
                .orders(findOrderResults)
                .build();
    }
}

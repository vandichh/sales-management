package com.example.sale_server.adaptor.coreapi.response.order;

import com.example.sale_server.domain.coreapi.result.order.CoreApiFetchOrdersResult;
import com.example.sale_server.domain.coreapi.result.order.CoreApiFindOrderResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoreApiFetchOrdersResponse {
    public final List<CoreApiFindOrderResponse> orders;

    public CoreApiFetchOrdersResult toResult() {
        List<CoreApiFindOrderResult> orderResults = this.orders.stream().map(CoreApiFindOrderResponse::toResult).toList();

        return CoreApiFetchOrdersResult.builder()
                .orders(orderResults)
                .build();
    }
}

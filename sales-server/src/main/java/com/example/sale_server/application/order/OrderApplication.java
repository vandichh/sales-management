package com.example.sale_server.application.order;

import com.example.sale_server.application.order.result.FetchOrdersResult;
import com.example.sale_server.domain.coreapi.CoreOrderApi;
import com.example.sale_server.domain.coreapi.result.order.CoreApiFetchOrdersResult;
import com.example.sale_server.domain.value.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderApplication {
    private final CoreOrderApi coreOrderApi;

    public FetchOrdersResult fetchOrders() {
        Either<CoreApiFetchOrdersResult> either = coreOrderApi.fetchOrders();
        if (!either.isSuccess()) {
            throw new RuntimeException("Fetch orders failed");
        }
        CoreApiFetchOrdersResult coreApiFetchOrdersResult = either.success();
        return FetchOrdersResult.initResult(coreApiFetchOrdersResult);
    }
}

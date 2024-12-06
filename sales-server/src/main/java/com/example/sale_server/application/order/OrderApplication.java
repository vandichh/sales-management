package com.example.sale_server.application.order;

import com.example.sale_server.application.order.result.FetchOrdersResult;
import com.example.sale_server.application.order.result.FindOrderResult;
import com.example.sale_server.domain.coreapi.CoreOrderApi;
import com.example.sale_server.domain.coreapi.result.order.CoreApiFetchOrdersResult;
import com.example.sale_server.domain.coreapi.result.order.CoreApiFindOrderResult;
import com.example.sale_server.domain.exception.ResourceNotFoundException;
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
            throw ResourceNotFoundException.fromCoreApi(either);
        }
        CoreApiFetchOrdersResult coreApiFetchOrdersResult = either.success();
        return FetchOrdersResult.initResult(coreApiFetchOrdersResult);
    }

    public FindOrderResult findOrder(int orderId) {
        Either<CoreApiFindOrderResult> either = coreOrderApi.findOrder(orderId);
        if (!either.isSuccess()) {
            throw ResourceNotFoundException.fromCoreApi(either);
        }
        CoreApiFindOrderResult coreApiFindOrderResult = either.success();
        return FindOrderResult.initResult(coreApiFindOrderResult);
    }
}

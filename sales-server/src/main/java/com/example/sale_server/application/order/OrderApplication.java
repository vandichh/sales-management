package com.example.sale_server.application.order;

import com.example.sale_server.application.order.result.FetchOrdersResult;
import com.example.sale_server.domain.order.OrderApi;
import com.example.sale_server.domain.order.result.OrderApiFetchOrdersResult;
import com.example.sale_server.domain.value.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderApplication {
    private final OrderApi orderApi;

    public FetchOrdersResult fetchOrders() {
        Either<OrderApiFetchOrdersResult> either = orderApi.fetchOrders();
        if (!either.isSuccess()) {
            throw new RuntimeException("Fetch orders failed");
        }
        OrderApiFetchOrdersResult orderApiFetchOrdersResult = either.success();
        return FetchOrdersResult.create(orderApiFetchOrdersResult);
    }
}

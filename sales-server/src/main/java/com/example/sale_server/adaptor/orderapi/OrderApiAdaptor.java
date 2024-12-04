package com.example.sale_server.adaptor.orderapi;

import com.example.sale_server.adaptor.orderapi.response.OrderApiFetchOrdersResponse;
import com.example.sale_server.domain.order.OrderApi;
import com.example.sale_server.domain.order.result.OrderApiFetchOrdersResult;
import com.example.sale_server.domain.value.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OrderApiAdaptor implements OrderApi {
    private final OrderApiAdaptorSupport support;

    @Override
    public void healthCheck() {
        RequestEntity<Void> request = this.support.initGet("/health-check").build();
        this.support.execute(request, Void.class);
    }

    @Override
    public Either<OrderApiFetchOrdersResult> fetchOrders() {
        RequestEntity<Void> request = this.support.initGet("/orders").build();
        Either<OrderApiFetchOrdersResponse> response = this.support.execute(request, OrderApiFetchOrdersResponse.class);
        return response.map(OrderApiFetchOrdersResponse::toResult);
    }
}

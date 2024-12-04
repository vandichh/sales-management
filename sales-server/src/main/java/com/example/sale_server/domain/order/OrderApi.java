package com.example.sale_server.domain.order;

import com.example.sale_server.domain.order.result.OrderApiFetchOrdersResult;
import com.example.sale_server.domain.value.Either;

public interface OrderApi {
    void healthCheck();

    Either<OrderApiFetchOrdersResult> fetchOrders();

}


package com.example.sale_server.domain.coreapi;

import com.example.sale_server.domain.coreapi.result.order.CoreApiFetchOrdersResult;
import com.example.sale_server.domain.value.Either;

public interface CoreOrderApi {

    Either<CoreApiFetchOrdersResult> fetchOrders();

}


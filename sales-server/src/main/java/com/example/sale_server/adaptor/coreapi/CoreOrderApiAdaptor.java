package com.example.sale_server.adaptor.coreapi;

import com.example.sale_server.adaptor.coreapi.response.order.CoreApiFetchOrdersResponse;
import com.example.sale_server.domain.coreapi.CoreOrderApi;
import com.example.sale_server.domain.coreapi.result.order.CoreApiFetchOrdersResult;
import com.example.sale_server.domain.value.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CoreOrderApiAdaptor implements CoreOrderApi {
    private final CoreAdaptorSupport support;

    @Override
    public Either<CoreApiFetchOrdersResult> fetchOrders() {
        RequestEntity<Void> request = this.support.initGet("/orders").build();
        Either<CoreApiFetchOrdersResponse> response = this.support.execute(request, CoreApiFetchOrdersResponse.class);
        return response.map(CoreApiFetchOrdersResponse::toResult);
    }
}

package com.example.sale_server.adaptor.coreapi;

import com.example.sale_server.adaptor.coreapi.response.product.CoreApiFetchProductsResponse;
import com.example.sale_server.domain.coreapi.CoreProductApi;
import com.example.sale_server.domain.coreapi.result.product.CoreApiFetchProductsResult;
import com.example.sale_server.domain.value.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CoreProductApiAdaptor implements CoreProductApi {
    private final CoreAdaptorSupport support;

    @Override
    public Either<CoreApiFetchProductsResult> fetchProducts() {
        RequestEntity<Void> request = this.support.initGet("/products").build();
        Either<CoreApiFetchProductsResponse> response = this.support.execute(request, CoreApiFetchProductsResponse.class);
        return response.map(CoreApiFetchProductsResponse::toResult);
    }
}

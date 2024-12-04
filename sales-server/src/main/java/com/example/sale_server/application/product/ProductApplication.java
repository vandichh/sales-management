package com.example.sale_server.application.product;

import com.example.sale_server.application.product.result.FetchProductsResult;
import com.example.sale_server.domain.coreapi.CoreProductApi;
import com.example.sale_server.domain.coreapi.result.product.CoreApiFetchProductsResult;
import com.example.sale_server.domain.value.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductApplication {
    private final CoreProductApi coreProductApi;

    public FetchProductsResult fetchProducts() {
        Either<CoreApiFetchProductsResult> either = coreProductApi.fetchProducts();
        if (!either.isSuccess()) {
            throw new RuntimeException();
        }
        CoreApiFetchProductsResult coreApiFetchOrdersResult = either.success();
        return FetchProductsResult.create(coreApiFetchOrdersResult);
    }
}

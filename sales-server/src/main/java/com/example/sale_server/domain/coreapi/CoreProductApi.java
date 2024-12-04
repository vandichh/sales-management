package com.example.sale_server.domain.coreapi;

import com.example.sale_server.domain.coreapi.result.product.CoreApiFetchProductsResult;
import com.example.sale_server.domain.value.Either;

public interface CoreProductApi {

    Either<CoreApiFetchProductsResult> fetchProducts();

}


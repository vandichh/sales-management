package com.example.sale_server.domain.coreapi.result.product;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoreApiFetchProductsResult {
    public final List<CoreApiFindProductResult> products;
}

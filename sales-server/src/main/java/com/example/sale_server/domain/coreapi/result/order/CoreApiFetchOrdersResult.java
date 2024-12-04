package com.example.sale_server.domain.coreapi.result.order;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoreApiFetchOrdersResult {
    public final List<CoreApiFindOrderResult> orders;
}

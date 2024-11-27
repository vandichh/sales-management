package com.example.sale_server.adaptor.orderapi;

import com.example.sale_server.domain.value.Either;
import com.example.sale_server.domain.value.order.OrderApi;
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
}

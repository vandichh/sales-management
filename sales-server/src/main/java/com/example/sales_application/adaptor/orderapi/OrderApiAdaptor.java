package com.example.sales_application.adaptor.orderapi;

import com.example.sales_application.domain.value.order.OrderApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OrderApiAdaptor implements OrderApi {
    private final OrderApiAdaptorSupport support;
}

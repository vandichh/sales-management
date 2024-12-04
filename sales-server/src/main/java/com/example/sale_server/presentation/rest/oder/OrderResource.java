package com.example.sale_server.presentation.rest.oder;

import com.example.sale_server.application.order.OrderApplication;
import com.example.sale_server.presentation.rest.oder.response.FetchOrdersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderResource {
    private final OrderApplication orderApplication;

    @GetMapping("")
    public FetchOrdersResponse getOrders() {
        return FetchOrdersResponse.create(orderApplication.fetchOrders());
    }
}

package com.example.sale_server.presentation.rest.oder;

import com.example.sale_server.application.order.OrderApplication;
import com.example.sale_server.presentation.rest.oder.response.FetchOrdersResponse;
import com.example.sale_server.presentation.rest.oder.response.FindOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderResource {
    private final OrderApplication orderApplication;

    @GetMapping("")
    public FetchOrdersResponse fetchOrders() {
        return FetchOrdersResponse.initResponse(orderApplication.fetchOrders());
    }

    @GetMapping("/{orderId}")
    public FindOrderResponse findOrder(@PathVariable int orderId) {
        return FindOrderResponse.initResponse(orderApplication.findOrder(orderId));
    }
}

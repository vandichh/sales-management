package com.example.sales_core.presentation.rest.order;

import com.example.sales_core.application.order.OrderApplication;
import com.example.sales_core.presentation.rest.order.resopnse.FetchOrdersResponse;
import com.example.sales_core.presentation.rest.order.resopnse.FindOrderResponse;
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

    @GetMapping("/{id}")
    public FindOrderResponse findOrder(@PathVariable int id) {
        return FindOrderResponse.initResponse(orderApplication.findOrder(id));
    }
}

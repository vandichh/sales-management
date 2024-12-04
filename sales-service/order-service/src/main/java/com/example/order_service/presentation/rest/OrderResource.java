package com.example.order_service.presentation.rest;

import com.example.order_service.application.OrderApplication;
import com.example.order_service.presentation.rest.resopnse.FetchOrdersResponse;
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
        return orderApplication.getAllOrders();
    }
}

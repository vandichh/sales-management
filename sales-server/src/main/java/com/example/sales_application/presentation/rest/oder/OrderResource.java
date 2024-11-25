package com.example.sales_application.presentation.rest.oder;

import com.example.sales_application.application.OrderApplication;
import com.example.sales_application.presentation.rest.oder.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderResource {
    private final OrderApplication orderApplication;

    @PostMapping("/process-order")
    public String processOrder(@RequestBody OrderRequest orderRequest) {
        return orderApplication.processOrder(orderRequest);
    }
}

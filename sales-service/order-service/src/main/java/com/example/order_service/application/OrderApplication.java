package com.example.order_service.application;

import com.example.order_service.application.result.FetchOrdersResult;
import com.example.order_service.presentation.rest.resopnse.FetchOrdersResponse;
import com.example.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderApplication {
    private final OrderRepository orderRepository;

    public FetchOrdersResponse getAllOrders() {
        FetchOrdersResult fetchOrdersResult = FetchOrdersResult.create(orderRepository.findAll());
        return FetchOrdersResponse.create(fetchOrdersResult);
    }
}

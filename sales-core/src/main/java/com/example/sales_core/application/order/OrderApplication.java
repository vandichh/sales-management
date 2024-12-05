package com.example.sales_core.application.order;

import com.example.sales_core.application.order.result.FetchOrdersResult;
import com.example.sales_core.application.order.result.FindOrderResult;
import com.example.sales_core.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderApplication {
    private final OrderRepository orderRepository;

    public FetchOrdersResult fetchOrders() {
        return FetchOrdersResult.initResult(orderRepository.findAll());
    }

    public FindOrderResult findOrder(int id) {
        return FindOrderResult.initResult(orderRepository.findById(id));
    }
}

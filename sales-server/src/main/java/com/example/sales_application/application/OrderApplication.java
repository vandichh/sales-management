package com.example.sales_application.application;

import com.example.sales_application.domain.value.order.OrderApi;
import com.example.sales_application.domain.value.product.ProductApi;
import com.example.sales_application.domain.value.user.UserApi;
import com.example.sales_application.presentation.rest.oder.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderApplication {
    private final RestTemplate restTemplate;
    private final OrderApi orderApi;
    private final ProductApi productApi;
    private final UserApi userApi;

    public String processOrder(OrderRequest orderRequest) {
        // Call user-service
        userApi.verifyUser();

        //        // Call product-service
        //        String productServiceResponse = restTemplate.getForObject(
        //                "http://localhost:8181/api/products/check",
        //                String.class
        //        );
        //
        //        // Call order-service
        //        String orderServiceResponse = restTemplate.getForObject(
        //                "http://localhost:8180/api/orders/check",
        //                String.class
        //        );

        return "Order processed successfully";
    }
}

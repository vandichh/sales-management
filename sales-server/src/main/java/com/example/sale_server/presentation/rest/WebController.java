package com.example.sale_server.presentation.rest;

import com.example.sale_server.domain.order.OrderApi;
import com.example.sale_server.domain.product.ProductApi;
import com.example.sale_server.domain.user.UserApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WebController {
    private final UserApi userApi;
    private final OrderApi orderApi;
    private final ProductApi productApi;

    @GetMapping("/health-check")
    public String healthCheck() {
        log.info("Sale-server is already");
        userApi.healthCheck();
        orderApi.healthCheck();
        productApi.healthCheck();
        return "All services are already.";
    }
}

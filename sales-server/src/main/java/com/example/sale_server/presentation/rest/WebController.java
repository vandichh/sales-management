package com.example.sale_server.presentation.rest;

import com.example.sale_server.domain.value.order.OrderApi;
import com.example.sale_server.domain.value.product.ProductApi;
import com.example.sale_server.domain.value.user.UserApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

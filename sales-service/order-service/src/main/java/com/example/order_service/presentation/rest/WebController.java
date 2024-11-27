package com.example.order_service.presentation.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WebController {

    @GetMapping("/health-check")
    public void healthCheck() {
        log.info("Order-service is already");
    }
}

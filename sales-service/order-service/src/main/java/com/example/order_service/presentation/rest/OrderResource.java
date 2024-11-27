package com.example.order_service.presentation.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderResource {
    @GetMapping("/check")
    public void check() {
        log.info("Checking orders");
    }
}

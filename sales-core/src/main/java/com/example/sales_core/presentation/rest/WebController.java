package com.example.sales_core.presentation.rest;

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
        log.info("Core application is already");
    }
}

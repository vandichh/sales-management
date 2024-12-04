package com.example.sale_server.presentation.rest;

import com.example.sale_server.domain.coreapi.CoreWebApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WebController {
    private final CoreWebApi coreWebApi;

    @GetMapping("/health-check")
    public String healthCheck() {
        log.info("Sale-server is already");
        coreWebApi.healthCheck();
        return "All services are already.";
    }
}

package com.example.user_service.presention.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserResource {

    @GetMapping("/verify")
    public void verifyUser() {
        log.info("Verifying user");
    }
}

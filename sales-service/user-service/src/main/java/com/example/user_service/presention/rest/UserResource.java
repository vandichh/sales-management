package com.example.user_service.presention.rest;

import com.example.user_service.application.UserApplication;
import com.example.user_service.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {
    private final UserApplication userApplication;

    @GetMapping
    public List<User> getUsers() {
        return userApplication.getAllUsers();
    }
}

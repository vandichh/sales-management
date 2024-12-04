package com.example.sales_core.presentation.rest.user;

import com.example.sales_core.application.user.UserApplication;
import com.example.sales_core.presentation.rest.user.response.FetchUsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {
    private final UserApplication userApplication;

    @GetMapping("")
    public FetchUsersResponse getOrders() {
        return FetchUsersResponse.create(userApplication.fetchProducts());
    }
}

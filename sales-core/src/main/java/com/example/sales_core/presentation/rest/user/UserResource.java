package com.example.sales_core.presentation.rest.user;

import com.example.sales_core.application.user.UserApplication;
import com.example.sales_core.presentation.rest.user.response.FetchUsersResponse;
import com.example.sales_core.presentation.rest.user.response.FindUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {
    private final UserApplication userApplication;

    @GetMapping("")
    public FetchUsersResponse fetchUsers() {
        return FetchUsersResponse.initResponse(userApplication.fetchUsers());
    }

    @GetMapping("/{id}")
    public FindUserResponse findUser(@PathVariable String id) {
        return FindUserResponse.initResponse(userApplication.findUser(id));
    }
}

package com.example.sale_server.presentation.rest.user;

import com.example.sale_server.application.user.UserApplication;
import com.example.sale_server.presentation.rest.user.response.FetchUsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResoucre {
    private final UserApplication userApplication;

    @GetMapping("")
    public FetchUsersResponse fetchUsers() {
        return FetchUsersResponse.initResponse(userApplication.fetchUsers());
    }
}

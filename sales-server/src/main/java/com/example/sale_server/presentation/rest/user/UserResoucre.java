package com.example.sale_server.presentation.rest.user;

import com.example.sale_server.application.user.UserApplication;
import com.example.sale_server.presentation.rest.user.request.CreateUserRequest;
import com.example.sale_server.presentation.rest.user.response.FetchUsersResponse;
import com.example.sale_server.presentation.rest.user.response.FindUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResoucre {
    private final UserApplication userApplication;

    @GetMapping("")
    public FetchUsersResponse fetchUsers() {
        return FetchUsersResponse.initResponse(userApplication.fetchUsers());
    }

    @GetMapping("/{userId}")
    public FindUserResponse fetchUsers(@PathVariable String userId) {
        return FindUserResponse.initResponse(userApplication.findUser(userId));
    }

    @PostMapping("")
    public void createUser(@RequestBody CreateUserRequest createUserRequest) {
        userApplication.createUser(createUserRequest);
    }
}

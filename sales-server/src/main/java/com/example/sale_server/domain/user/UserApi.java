package com.example.sale_server.domain.user;

import com.example.sale_server.domain.user.result.UserResult;

import java.util.List;

public interface UserApi {
    void healthCheck();

    List<UserResult> getUsers();
}

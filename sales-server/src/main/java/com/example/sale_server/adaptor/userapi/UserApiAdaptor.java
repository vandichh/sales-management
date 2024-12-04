package com.example.sale_server.adaptor.userapi;

import com.example.sale_server.adaptor.userapi.response.UserResponse;
import com.example.sale_server.domain.user.UserApi;
import com.example.sale_server.domain.user.result.UserResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserApiAdaptor implements UserApi {
    private final UserApiAdaptorSupport support;

    @Override
    public void healthCheck() {
        RequestEntity<Void> request = this.support.initGet("/health-check").build();
        this.support.execute(request, Void.class);
    }

    @Override
    public List<UserResult> getUsers() {
        RequestEntity<Void> request = this.support.initGet("/users").build();
        return this.support.execute(request, UserResponse.class).success().users;
    }
}

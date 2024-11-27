package com.example.sale_server.adaptor.userapi;

import com.example.sale_server.domain.value.Either;
import com.example.sale_server.domain.value.user.UserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;

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
    public void failure() {
        RequestEntity<Void> request = this.support.initGet("/failure").build();
        this.support.execute(request, Void.class);
    }
}

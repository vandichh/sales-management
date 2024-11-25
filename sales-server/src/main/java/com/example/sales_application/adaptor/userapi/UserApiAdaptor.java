package com.example.sales_application.adaptor.userapi;

import com.example.sales_application.domain.value.user.UserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserApiAdaptor implements UserApi {
    private final UserApiAdaptorSupport support;

    @Override
    public void verifyUser() {
        RequestEntity<Void> request = this.support.initGet("/users/verify").build();
        this.support.execute(request, Void.class);
    }
}

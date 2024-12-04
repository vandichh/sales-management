package com.example.sale_server.adaptor.coreapi;

import com.example.sale_server.adaptor.coreapi.response.user.CoreApiFetchUsersResponse;
import com.example.sale_server.domain.coreapi.CoreUserApi;
import com.example.sale_server.domain.coreapi.result.user.CoreApiFetchUsersResult;
import com.example.sale_server.domain.value.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CoreUserApiAdaptor implements CoreUserApi {
    private final CoreAdaptorSupport support;

    @Override
    public Either<CoreApiFetchUsersResult> fetchUsers() {
        RequestEntity<Void> request = this.support.initGet("/users").build();
        Either<CoreApiFetchUsersResponse> response = this.support.execute(request, CoreApiFetchUsersResponse.class);
        return response.map(CoreApiFetchUsersResponse::toResult);
    }
}

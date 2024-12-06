package com.example.sale_server.adaptor.coreapi;

import com.example.sale_server.adaptor.coreapi.response.user.CoreApiFetchUsersResponse;
import com.example.sale_server.adaptor.coreapi.response.user.CoreApiFindUserResponse;
import com.example.sale_server.domain.coreapi.CoreUserApi;
import com.example.sale_server.domain.coreapi.result.user.CoreApiFetchUsersResult;
import com.example.sale_server.domain.coreapi.result.user.CoreApiFindUserResult;
import com.example.sale_server.domain.value.Either;
import com.example.sale_server.presentation.rest.user.request.CreateUserRequest;
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

    @Override
    public Either<CoreApiFindUserResult> findUser(String userId) {
        RequestEntity<Void> request = this.support.initGet("/users/" + userId).build();
        Either<CoreApiFindUserResponse> response = this.support.execute(request, CoreApiFindUserResponse.class);
        return response.map(CoreApiFindUserResponse::toResult);
    }

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        RequestEntity<CreateUserRequest> request = this.support.initPost("/users").body(createUserRequest);
        this.support.execute(request, Void.class);
    }
}

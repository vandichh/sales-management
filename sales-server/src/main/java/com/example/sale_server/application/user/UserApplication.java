package com.example.sale_server.application.user;

import com.example.sale_server.application.user.result.FetchUsersResult;
import com.example.sale_server.application.user.result.FindUserResult;
import com.example.sale_server.domain.coreapi.CoreUserApi;
import com.example.sale_server.domain.coreapi.result.user.CoreApiFetchUsersResult;
import com.example.sale_server.domain.coreapi.result.user.CoreApiFindUserResult;
import com.example.sale_server.domain.exception.ResourceNotFoundException;
import com.example.sale_server.domain.value.Either;
import com.example.sale_server.presentation.rest.user.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApplication {
    private final CoreUserApi coreUserApi;

    public FetchUsersResult fetchUsers() {
        Either<CoreApiFetchUsersResult> either = coreUserApi.fetchUsers();
        if (!either.isSuccess()) {
            throw ResourceNotFoundException.fromCoreApi(either);
        }
        CoreApiFetchUsersResult coreApiFetchOrdersResult = either.success();
        return FetchUsersResult.initResult(coreApiFetchOrdersResult);
    }

    public FindUserResult findUser(String userId) {
        Either<CoreApiFindUserResult> either = coreUserApi.findUser(userId);
        if (!either.isSuccess()) {
            throw ResourceNotFoundException.fromCoreApi(either);
        }
        CoreApiFindUserResult coreApiFetchOrdersResult = either.success();
        return FindUserResult.initResult(coreApiFetchOrdersResult);
    }

    public void createUser(CreateUserRequest createUserRequest) {
        coreUserApi.createUser(createUserRequest);
    }
}

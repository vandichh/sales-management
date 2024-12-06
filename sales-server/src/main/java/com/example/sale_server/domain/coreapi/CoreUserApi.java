package com.example.sale_server.domain.coreapi;

import com.example.sale_server.domain.coreapi.result.user.CoreApiFetchUsersResult;
import com.example.sale_server.domain.coreapi.result.user.CoreApiFindUserResult;
import com.example.sale_server.domain.value.Either;
import com.example.sale_server.presentation.rest.user.request.CreateUserRequest;

public interface CoreUserApi {

    Either<CoreApiFetchUsersResult> fetchUsers();

    Either<CoreApiFindUserResult> findUser(String userId);

    void createUser(CreateUserRequest createUserRequest);
}


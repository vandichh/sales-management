package com.example.sale_server.domain.coreapi;

import com.example.sale_server.domain.coreapi.result.user.CoreApiFetchUsersResult;
import com.example.sale_server.domain.value.Either;

public interface CoreUserApi {

    Either<CoreApiFetchUsersResult> fetchUsers();

}


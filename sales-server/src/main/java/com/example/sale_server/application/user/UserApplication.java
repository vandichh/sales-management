package com.example.sale_server.application.user;

import com.example.sale_server.application.user.result.FetchUsersResult;
import com.example.sale_server.domain.coreapi.CoreUserApi;
import com.example.sale_server.domain.coreapi.result.user.CoreApiFetchUsersResult;
import com.example.sale_server.domain.value.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApplication {
    private final CoreUserApi coreUserApi;


    public FetchUsersResult fetchUsers() {
        Either<CoreApiFetchUsersResult> either = coreUserApi.fetchUsers();
        if (!either.isSuccess()) {
            throw new RuntimeException();
        }
        CoreApiFetchUsersResult coreApiFetchOrdersResult = either.success();
        return FetchUsersResult.initResult(coreApiFetchOrdersResult);
    }
}

package com.example.sale_server.application.user.result;

import com.example.sale_server.domain.coreapi.result.user.CoreApiFetchUsersResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchUsersResult {
    public final List<FindUserResult> users;

    public static FetchUsersResult initResult(CoreApiFetchUsersResult coreApiFetchUsersResult) {
        List<FindUserResult> users = coreApiFetchUsersResult.users.stream().map(FindUserResult::initResult).toList();
        return FetchUsersResult.builder()
                .users(users)
                .build();
    }
}

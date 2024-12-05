package com.example.sale_server.presentation.rest.user.response;

import com.example.sale_server.application.user.result.FetchUsersResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchUsersResponse {
    public final int total;
    public final List<FindUserResponse> users;

    public static FetchUsersResponse initResponse(FetchUsersResult coreApiFetchUsersResult) {
        List<FindUserResponse> users = coreApiFetchUsersResult.users.stream().map(FindUserResponse::initResponse).toList();
        return FetchUsersResponse.builder()
                .users(users)
                .total(users.size())
                .build();
    }
}

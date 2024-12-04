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

    public static FetchUsersResponse create(FetchUsersResult coreApiFetchUsersResult) {
        List<FindUserResponse> users = coreApiFetchUsersResult.users.stream().map(FindUserResponse::create).toList();
        return FetchUsersResponse.builder()
                .users(users)
                .total(users.size())
                .build();
    }
}

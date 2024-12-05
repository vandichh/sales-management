package com.example.sales_core.presentation.rest.user.response;

import com.example.sales_core.application.user.result.FetchUsersResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchUsersResponse {
    public final int total;
    public final List<FindUserResponse> users;

    public static FetchUsersResponse initResponse(FetchUsersResult fetchUsersResult) {
        List<FindUserResponse> users = fetchUsersResult.users.stream().map(FindUserResponse::initResponse).toList();
        return FetchUsersResponse.builder()
                .users(users)
                .total(users.size())
                .build();
    }
}

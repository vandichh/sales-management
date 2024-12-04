package com.example.sale_server.adaptor.coreapi.response.user;

import com.example.sale_server.domain.coreapi.result.user.CoreApiFetchUsersResult;
import com.example.sale_server.domain.coreapi.result.user.CoreApiFindUserResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoreApiFetchUsersResponse {
    public final List<CoreApiFindUserResponse> users;

    public CoreApiFetchUsersResult toResult() {
        List<CoreApiFindUserResult> userResults = this.users.stream().map(CoreApiFindUserResponse::toResult).toList();

        return CoreApiFetchUsersResult.builder()
                .users(userResults)
                .build();
    }
}

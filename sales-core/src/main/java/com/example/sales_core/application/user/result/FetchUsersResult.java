package com.example.sales_core.application.user.result;

import com.example.sales_core.domain.entity.user.UserEntitty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchUsersResult {
    public final List<FindUserResult> users;

    public static FetchUsersResult initResult(List<UserEntitty> users) {
        List<FindUserResult> usersResult = users.stream().map(FindUserResult::initResult).toList();
        return FetchUsersResult.builder()
                .users(usersResult)
                .build();
    }
}

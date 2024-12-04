package com.example.sales_core.application.user.result;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FetchUsersResult {
    public final List<FindUserResult> users;

    public static FetchUsersResult create() {
        return FetchUsersResult.builder()
                .build();
    }
}

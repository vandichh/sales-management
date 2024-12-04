package com.example.sales_core.application.user.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindUserResult {
    public final String userId;
    public final String username;
    public final String password;
    public final String email;
    public final String phoneNumber;
    public final String fullName;
    public final boolean isActive;
    public final String roleId;

    public static FindUserResult create() {
        return FindUserResult.builder()
                .build();
    }

}

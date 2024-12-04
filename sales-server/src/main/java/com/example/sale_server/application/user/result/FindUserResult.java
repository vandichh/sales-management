package com.example.sale_server.application.user.result;

import com.example.sale_server.domain.coreapi.result.user.CoreApiFindUserResult;
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

    public static FindUserResult create(CoreApiFindUserResult coreApiFindUserResult) {
        return FindUserResult.builder()
                .userId(coreApiFindUserResult.getUserId())
                .username(coreApiFindUserResult.getUsername())
                .password(coreApiFindUserResult.getPassword())
                .email(coreApiFindUserResult.getEmail())
                .phoneNumber(coreApiFindUserResult.getPhoneNumber())
                .fullName(coreApiFindUserResult.getFullName())
                .isActive(coreApiFindUserResult.isActive())
                .roleId(coreApiFindUserResult.getRoleId())
                .build();
    }

}

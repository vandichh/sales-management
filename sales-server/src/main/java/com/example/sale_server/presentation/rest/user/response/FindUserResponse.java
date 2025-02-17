package com.example.sale_server.presentation.rest.user.response;

import com.example.sale_server.application.user.result.FindUserResult;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindUserResponse {
    public final String userId;
    public final String username;
    public final String password;
    public final String email;
    public final String phoneNumber;
    public final String fullName;
    public final boolean isActive;
    public final String roleId;

    public static FindUserResponse initResponse(FindUserResult findUserResult) {
        return FindUserResponse.builder()
                .userId(findUserResult.getUserId())
                .username(findUserResult.getUsername())
                .password(findUserResult.getPassword())
                .email(findUserResult.getEmail())
                .phoneNumber(findUserResult.getPhoneNumber())
                .fullName(findUserResult.getFullName())
                .isActive(findUserResult.isActive())
                .roleId(findUserResult.getRoleId())
                .build();
    }
}

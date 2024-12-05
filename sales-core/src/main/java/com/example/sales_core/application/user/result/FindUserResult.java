package com.example.sales_core.application.user.result;

import com.example.sales_core.domain.entity.user.UserEntitty;
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

    public static FindUserResult create(UserEntitty userEntitty) {
        return FindUserResult.builder()
                .userId(userEntitty.getUserId())
                .username(userEntitty.getUsername())
                .password(userEntitty.getPassword())
                .email(userEntitty.getEmail())
                .phoneNumber(userEntitty.getPhoneNumber())
                .fullName(userEntitty.getFullName())
                .isActive(userEntitty.isActive())
                .roleId(userEntitty.getRoleId())
                .build();
    }

}

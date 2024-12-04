package com.example.sale_server.adaptor.coreapi.response.user;

import com.example.sale_server.domain.coreapi.result.user.CoreApiFindUserResult;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoreApiFindUserResponse {
    public final String userId;
    public final String username;
    public final String password;
    public final String email;
    public final String phoneNumber;
    public final String fullName;
    public final boolean isActive;
    public final String roleId;

    public CoreApiFindUserResult toResult() {
        return CoreApiFindUserResult.builder()
                .userId(this.userId)
                .username(this.username)
                .password(this.password)
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .fullName(this.fullName)
                .isActive(this.isActive)
                .roleId(this.roleId)
                .build();
    }
}

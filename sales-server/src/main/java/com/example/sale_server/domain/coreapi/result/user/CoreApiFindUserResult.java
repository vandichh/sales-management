package com.example.sale_server.domain.coreapi.result.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoreApiFindUserResult {
    public final String userId;
    public final String username;
    public final String password;
    public final String email;
    public final String phoneNumber;
    public final String fullName;
    public final boolean isActive;
    public final String roleId;
}

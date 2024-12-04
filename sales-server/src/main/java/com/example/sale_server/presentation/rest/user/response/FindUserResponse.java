package com.example.sale_server.presentation.rest.user.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindUserResponse {
    private String userId;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String fullName;
    private boolean isActive;
    private String roleId;
}

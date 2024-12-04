package com.example.sale_server.domain.user.result;

import lombok.Data;

@Data
public class UserResult {
    private String userId;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String fullName;
    private boolean isActive;
    private String roleId;
}

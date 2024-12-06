package com.example.sales_core.application.user;

import com.example.sales_core.application.user.result.FetchUsersResult;
import com.example.sales_core.application.user.result.FindUserResult;
import com.example.sales_core.domain.entity.user.UserEntitty;
import com.example.sales_core.domain.repository.UserRepository;
import com.example.sales_core.presentation.rest.user.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApplication {
    private final UserRepository userRepository;

    public FetchUsersResult fetchUsers() {
        return FetchUsersResult.initResult(userRepository.findAll());
    }

    public FindUserResult findUser(String userId) {
        return FindUserResult.initResult(userRepository.findById(userId));
    }

    public void createUser(CreateUserRequest createUserRequest) {
        UserEntitty userEntitty = UserEntitty.builder()
                .userId(createUserRequest.getUserId())
                .username(createUserRequest.getUsername())
                .password(createUserRequest.getPassword())
                .email(createUserRequest.getEmail())
                .fullName(createUserRequest.getFullName())
                .isActive(createUserRequest.isActive())
                .phoneNumber(createUserRequest.getPhoneNumber())
                .roleId(createUserRequest.getRoleId())
                .build();

        userRepository.save(userEntitty);
    }
}

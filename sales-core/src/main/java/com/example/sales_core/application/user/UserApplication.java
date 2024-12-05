package com.example.sales_core.application.user;

import com.example.sales_core.application.user.result.FetchUsersResult;
import com.example.sales_core.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApplication {
    private final UserRepository userRepository;

    public FetchUsersResult fetchProducts() {
        return FetchUsersResult.create(userRepository.findAll());
    }
}

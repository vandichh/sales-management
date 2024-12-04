package com.example.sale_server.application.user;

import com.example.sale_server.domain.user.UserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApplication {
    private final UserApi userApi;
}

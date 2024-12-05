package com.example.sales_core.domain.repository;

import com.example.sales_core.domain.entity.user.UserEntitty;

import java.util.List;

public interface UserRepository {
    List<UserEntitty> findAll();

    UserEntitty findById(String id);

    UserEntitty save(UserEntitty userEntitty);
}

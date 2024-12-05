package com.example.sales_core.adaptor.db.dao;

import com.example.sales_core.domain.entity.user.UserEntitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepositoryDao extends JpaRepository<UserEntitty, String> {
}

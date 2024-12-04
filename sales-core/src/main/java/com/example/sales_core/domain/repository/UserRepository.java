package com.example.sales_core.domain.repository;

import com.example.sales_core.domain.entity.user.UserEntitty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntitty, Long> {
}

package com.example.sales_core.adaptor.db;

import com.example.sales_core.adaptor.db.dao.UserRepositoryDao;
import com.example.sales_core.domain.entity.user.UserEntitty;
import com.example.sales_core.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository {
    private final UserRepositoryDao userRepositoryDao;

    @Override
    public List<UserEntitty> findAll() {
        return userRepositoryDao.findAll();
    }
}

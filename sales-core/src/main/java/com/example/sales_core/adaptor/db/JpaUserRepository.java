package com.example.sales_core.adaptor.db;

import com.example.sales_core.adaptor.db.dao.UserRepositoryDao;
import com.example.sales_core.domain.entity.user.UserEntitty;
import com.example.sales_core.domain.exception.ResoucreNotFoundException;
import com.example.sales_core.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository {
    private final UserRepositoryDao userRepositoryDao;

    @Override
    public List<UserEntitty> findAll() {
        return userRepositoryDao.findAll();
    }

    @Override
    public UserEntitty findById(String id) {
        Optional<UserEntitty> optionalUserEntity = userRepositoryDao.findById(id);
        if (optionalUserEntity.isEmpty()) {
            throw new ResoucreNotFoundException("User not found");
        }
        return optionalUserEntity.get();
    }

    @Override
    public UserEntitty save(UserEntitty userEntitty) {
        return userRepositoryDao.save(userEntitty);
    }
}

package com.example.cqrswrite.domain.user.persistence;

import com.example.cqrswrite.domain.user.model.User;
import com.example.cqrswrite.domain.user.persistence.mapper.UserMapper;
import com.example.cqrswrite.domain.user.persistence.repository.UserJpaRepository;
import com.example.cqrswrite.domain.user.spi.UserSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserPersistenceAdapter implements UserSpi {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User saveUser(User user) {
        return userMapper.toDomain(
                userJpaRepository.save(userMapper.toEntity(user))
        );
    }

    @Override
    public boolean existsUserByAccountId(String accountId) {
        return userJpaRepository.existsByAccountId(accountId);
    }
}

package com.example.cqrswrite.domain.user.persistence.mapper;

import com.example.cqrswrite.domain.user.model.User;
import com.example.cqrswrite.domain.user.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .accountId(entity.getAccountId())
                .password(entity.getPassword())
                .build();
    }

    public UserEntity toEntity(User domain) {
        return UserEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .accountId(domain.getAccountId())
                .password(domain.getPassword())
                .build();
    }
}

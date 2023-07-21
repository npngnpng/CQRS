package com.example.cqrswrite.domain.user.persistence.repository;

import com.example.cqrswrite.domain.user.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByAccountId(String accountId);
}

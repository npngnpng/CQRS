package com.example.cqrswrite.domain.user.persistence.repository;

import com.example.cqrswrite.domain.user.persistence.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, String> {
}

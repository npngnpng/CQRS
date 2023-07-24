package com.example.cqrswrite.domain.feed.persistence.repository;

import com.example.cqrswrite.domain.feed.persistence.entity.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeedJpaRepository extends JpaRepository<FeedEntity, UUID> {
}

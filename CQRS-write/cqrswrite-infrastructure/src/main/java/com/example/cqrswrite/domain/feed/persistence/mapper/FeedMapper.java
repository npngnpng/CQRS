package com.example.cqrswrite.domain.feed.persistence.mapper;

import com.example.cqrswrite.domain.feed.model.Feed;
import com.example.cqrswrite.domain.feed.persistence.entity.FeedEntity;
import com.example.cqrswrite.domain.user.exception.UserException;
import com.example.cqrswrite.domain.user.persistence.entity.UserEntity;
import com.example.cqrswrite.domain.user.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedMapper {

    private final UserJpaRepository userJpaRepository;

    public Feed toDomain(FeedEntity entity) {
        return Feed.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .userId(entity.getUserEntity().getId())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public FeedEntity toEntity(Feed domain) {
        UserEntity userEntity = userJpaRepository.findById(domain.getUserId())
                .orElseThrow(() -> UserException.USER_NOT_FOUND);

        return FeedEntity.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .content(domain.getContent())
                .userEntity(userEntity)
                .createdAt(domain.getCreatedAt())
                .build();
    }
}

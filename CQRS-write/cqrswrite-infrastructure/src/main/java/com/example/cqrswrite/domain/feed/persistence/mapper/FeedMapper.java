package com.example.cqrswrite.domain.feed.persistence.mapper;

import com.example.cqrswrite.domain.feed.model.Feed;
import com.example.cqrswrite.domain.feed.persistence.entity.FeedEntity;
import org.springframework.stereotype.Component;

@Component
public class FeedMapper {

    public Feed toDomain(FeedEntity entity) {
        return Feed.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public FeedEntity toEntity(Feed domain) {
        return FeedEntity.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .content(domain.getContent())
                .createdAt(domain.getCreatedAt())
                .build();
    }
}

package com.example.cqrsread.domain.feed.mapper

import com.example.cqrsread.domain.feed.model.FeedDetails
import com.example.cqrsread.domain.feed.model.Feeds
import com.example.cqrsread.domain.feed.persistence.entity.FeedDetailsEntity
import com.example.cqrsread.domain.feed.persistence.entity.FeedsEntity
import org.springframework.stereotype.Component

@Component
class FeedsMapper {
    suspend fun toDomain(entity: FeedsEntity): Feeds {
        return Feeds(
            id = entity.id,
            title = entity.title,
            createdAt = entity.createdAt,
            username = entity.username,
        )
    }

    suspend fun toEntity(domain: Feeds): FeedsEntity {
        return FeedsEntity(
            id = domain.id,
            title = domain.title,
            createdAt = domain.createdAt,
            username = domain.username,
        )
    }
}

@Component
class FeedDetailsMapper {
    suspend fun toDomain(entity: FeedDetailsEntity): FeedDetails {
        return FeedDetails(
            id = entity.id,
            title = entity.title,
            content = entity.content,
            username = entity.username,
            createdAt = entity.createdAt,
        )
    }

    suspend fun toEntity(domain: FeedDetails): FeedDetailsEntity {
        return FeedDetailsEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            username = domain.username,
            createdAt = domain.createdAt,
        )
    }
}
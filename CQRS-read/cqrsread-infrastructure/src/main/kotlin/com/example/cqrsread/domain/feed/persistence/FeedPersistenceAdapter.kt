package com.example.cqrsread.domain.feed.persistence

import com.example.cqrsread.domain.feed.event.vo.CreateFeedEvent
import com.example.cqrsread.domain.feed.persistence.entity.FeedDetailsEntity
import com.example.cqrsread.domain.feed.persistence.entity.FeedsEntity
import com.example.cqrsread.domain.feed.persistence.repository.FeedDetailsRepository
import com.example.cqrsread.domain.feed.persistence.repository.FeedsRepository
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component

@Component
class FeedPersistenceAdapter(
    private val feedDetailsRepository: FeedDetailsRepository,
    private val feedsRepository: FeedsRepository,
) {

    suspend fun saveFeedDetailsEntity(event: CreateFeedEvent) {
        feedDetailsRepository.save(
            FeedDetailsEntity(
                id = event.id.toString(),
                title = event.title,
                content = event.content,
                username = event.username,
                createdAt = event.createdAt
            )
        ).awaitSingle()
    }

    suspend fun saveFeedsEntity(event: CreateFeedEvent) {
        feedsRepository.save(
            FeedsEntity(
                id = event.id.toString(),
                title = event.title,
                createdAt = event.createdAt,
                username = event.username
            )
        ).awaitSingle()
    }
}
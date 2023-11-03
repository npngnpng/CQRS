package com.example.cqrsread.domain.feed.usecase

import com.example.cqrsread.common.annotation.UseCase
import com.example.cqrsread.domain.feed.dto.event.CreateFeedEvent
import com.example.cqrsread.domain.feed.model.FeedDetails
import com.example.cqrsread.domain.feed.model.Feeds
import com.example.cqrsread.domain.feed.spi.CommendFeedPort

@UseCase
class CreateFeedEventUseCase(
    private val commendFeedPort: CommendFeedPort,
) {

    suspend fun execute(event: CreateFeedEvent) {
        commendFeedPort.saveFeedsEntity(
            Feeds(
                id = event.id.toString(),
                title = event.title,
                createdAt = event.createdAt,
                username = event.username,
            )
        )
        commendFeedPort.saveFeedDetailsEntity(
            FeedDetails(
                id = event.id.toString(),
                title = event.title,
                content = event.content,
                createdAt = event.createdAt,
                username = event.username,
            )
        )
    }
}
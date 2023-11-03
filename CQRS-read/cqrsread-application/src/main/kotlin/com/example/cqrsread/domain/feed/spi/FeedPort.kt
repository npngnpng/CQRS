package com.example.cqrsread.domain.feed.spi

import com.example.cqrsread.domain.feed.dto.event.CreateFeedEvent
import com.example.cqrsread.domain.feed.model.FeedDetails
import com.example.cqrsread.domain.feed.model.Feeds
import kotlinx.coroutines.flow.Flow

interface FeedPort : QueryFeedPort, CommendFeedPort

interface QueryFeedPort {
    suspend fun queryFeeds(): Flow<Feeds>
    suspend fun queryFeedDetailsById(id: String): FeedDetails
}

interface CommendFeedPort {
    suspend fun saveFeedDetailsEntity(feedDetails: FeedDetails)
    suspend fun saveFeedsEntity(feeds: Feeds)
}
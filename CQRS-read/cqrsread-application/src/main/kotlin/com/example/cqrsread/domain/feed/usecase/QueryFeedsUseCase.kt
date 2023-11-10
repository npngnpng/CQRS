package com.example.cqrsread.domain.feed.usecase

import com.example.cqrsread.common.annotation.ReadOnlyUseCase
import com.example.cqrsread.domain.feed.dto.response.QueryFeedsResponse
import com.example.cqrsread.domain.feed.model.Feeds
import com.example.cqrsread.domain.feed.spi.QueryFeedPort
import kotlinx.coroutines.flow.Flow

@ReadOnlyUseCase
class QueryFeedsUseCase(
    private val queryFeedPort: QueryFeedPort,
) {

    suspend fun execute(): Flow<Feeds> {

        return queryFeedPort.queryFeeds()
    }
}
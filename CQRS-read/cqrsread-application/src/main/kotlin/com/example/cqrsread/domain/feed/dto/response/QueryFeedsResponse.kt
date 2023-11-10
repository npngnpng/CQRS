package com.example.cqrsread.domain.feed.dto.response

import com.example.cqrsread.domain.feed.model.Feeds
import kotlinx.coroutines.flow.Flow

data class QueryFeedsResponse(
    val feeds: Flow<Feeds>
)
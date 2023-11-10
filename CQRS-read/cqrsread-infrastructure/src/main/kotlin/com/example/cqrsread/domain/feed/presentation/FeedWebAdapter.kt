package com.example.cqrsread.domain.feed.presentation

import com.example.cqrsread.domain.feed.dto.response.QueryFeedsResponse
import com.example.cqrsread.domain.feed.model.Feeds
import com.example.cqrsread.domain.feed.usecase.QueryFeedsUseCase
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/feeds")
@RestController
class FeedWebAdapter(
    private val queryFeedsUseCase: QueryFeedsUseCase,
) {

    @GetMapping
    suspend fun queryFeeds(): Flow<Feeds> =
        queryFeedsUseCase.execute()
}
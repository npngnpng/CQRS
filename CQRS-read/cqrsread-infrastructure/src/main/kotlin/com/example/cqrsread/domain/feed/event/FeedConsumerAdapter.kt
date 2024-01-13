package com.example.cqrsread.domain.feed.event

import com.example.cqrsread.domain.feed.dto.event.CreateFeedEvent
import com.example.cqrsread.domain.feed.persistence.FeedPersistenceAdapter
import com.example.cqrsread.domain.feed.persistence.entity.FeedDetailsEntity
import com.example.cqrsread.domain.feed.persistence.entity.FeedsEntity
import com.example.cqrsread.domain.feed.persistence.repository.FeedDetailsRepository
import com.example.cqrsread.domain.feed.persistence.repository.FeedsRepository
import com.example.cqrsread.domain.feed.usecase.CreateFeedEventUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.runBlocking
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import kotlin.concurrent.thread

@Component
class FeedConsumerAdapter(
    private val createFeedEventUseCase: CreateFeedEventUseCase,
) {

    @KafkaListener(topics = ["feed"], groupId = "foo", containerFactory = "createFeedEventContainerFactory")
    fun createFeedEvent(event: CreateFeedEvent) {
        CoroutineScope(Dispatchers.IO).launch {
            createFeedEventUseCase.execute(event)
        }
    }
}

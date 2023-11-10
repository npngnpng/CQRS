package com.example.cqrsread.domain.feed.persistence

import com.example.cqrsread.domain.feed.dto.event.CreateFeedEvent
import com.example.cqrsread.domain.feed.mapper.FeedDetailsMapper
import com.example.cqrsread.domain.feed.mapper.FeedsMapper
import com.example.cqrsread.domain.feed.model.FeedDetails
import com.example.cqrsread.domain.feed.model.Feeds
import com.example.cqrsread.domain.feed.persistence.entity.FeedDetailsEntity
import com.example.cqrsread.domain.feed.persistence.entity.FeedsEntity
import com.example.cqrsread.domain.feed.persistence.repository.FeedDetailsRepository
import com.example.cqrsread.domain.feed.persistence.repository.FeedsRepository
import com.example.cqrsread.domain.feed.spi.FeedPort
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class FeedPersistenceAdapter(
    private val feedDetailsRepository: FeedDetailsRepository,
    private val feedsRepository: FeedsRepository,
    private val feedsMapper: FeedsMapper,
    private val feedDetailsMapper: FeedDetailsMapper,
) : FeedPort {

    override suspend fun saveFeedDetailsEntity(feedDetails: FeedDetails) {
        feedDetailsRepository.save(
            feedDetailsMapper.toEntity(feedDetails)
        ).awaitSingle()
    }

    override suspend fun saveFeedsEntity(feeds: Feeds) {
        feedsRepository.save(
            feedsMapper.toEntity(feeds)
        ).awaitSingle()
    }

    override suspend fun queryFeeds(): Flow<Feeds> =
        feedsRepository.findAll().asFlow().map {
            feedsMapper.toDomain(it)
        }

    override suspend fun queryFeedDetailsById(id: String): FeedDetails =
        feedDetailsMapper.toDomain(
            feedDetailsRepository.findById(id).awaitSingle()
        )
}
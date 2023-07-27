package com.example.cqrsread.domain.feed.persistence.repository

import com.example.cqrsread.domain.feed.persistence.entity.FeedDetailsEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import java.util.UUID

interface FeedDetailsRepository: ReactiveMongoRepository<FeedDetailsEntity, String> {


}
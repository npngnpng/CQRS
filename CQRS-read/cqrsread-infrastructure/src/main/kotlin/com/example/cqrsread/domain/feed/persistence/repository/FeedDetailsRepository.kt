package com.example.cqrsread.domain.feed.persistence.repository

import com.example.cqrsread.domain.feed.persistence.entity.FeedDetailsEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface FeedDetailsRepository: ReactiveMongoRepository<FeedDetailsEntity, String> {
}
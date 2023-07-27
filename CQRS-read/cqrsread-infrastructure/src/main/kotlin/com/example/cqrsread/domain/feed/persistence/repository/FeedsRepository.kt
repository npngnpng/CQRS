package com.example.cqrsread.domain.feed.persistence.repository

import com.example.cqrsread.domain.feed.persistence.entity.FeedsEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import java.util.UUID

interface FeedsRepository: ReactiveMongoRepository<FeedsEntity, String> {
}
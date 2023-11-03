package com.example.cqrsread.domain.feed.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("feed_details")
class FeedDetailsEntity(
    @Id val id: String,
    val title: String,
    val content: String,
    val username: String,
    val createdAt: LocalDateTime,
) {
}
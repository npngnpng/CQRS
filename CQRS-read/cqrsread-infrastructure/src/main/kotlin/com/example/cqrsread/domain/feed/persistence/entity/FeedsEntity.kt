package com.example.cqrsread.domain.feed.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("feeds")
class FeedsEntity(
    @Id val id: String,
    val title: String,
    val createdAt: LocalDateTime,
    val username: String,
) {

}
package com.example.cqrsread.domain.feed.dto.event

import java.time.LocalDateTime
import java.util.UUID

data class CreateFeedEvent(
    val id: UUID,
    val title: String,
    val content: String,
    val username: String,
    val createdAt: LocalDateTime
)
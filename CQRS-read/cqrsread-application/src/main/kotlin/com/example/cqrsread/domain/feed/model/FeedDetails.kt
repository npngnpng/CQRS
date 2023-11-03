package com.example.cqrsread.domain.feed.model

import com.example.cqrsread.common.annotation.Aggregate
import java.time.LocalDateTime

@Aggregate
data class FeedDetails(
    val id: String,
    val title: String,
    val content: String,
    val username: String,
    val createdAt: LocalDateTime,
)
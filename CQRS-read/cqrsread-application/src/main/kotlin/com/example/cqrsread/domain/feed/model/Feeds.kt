package com.example.cqrsread.domain.feed.model

import com.example.cqrsread.common.annotation.Aggregate
import java.time.LocalDateTime

@Aggregate
data class Feeds(
    val id: String,
    val title: String,
    val createdAt: LocalDateTime,
    val username: String,
)
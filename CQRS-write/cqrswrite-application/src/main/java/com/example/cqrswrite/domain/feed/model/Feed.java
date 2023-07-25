package com.example.cqrswrite.domain.feed.model;

import com.example.cqrswrite.common.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder(toBuilder = true)
@Aggregate
public class Feed {

    private final UUID id;
    private final String title;
    private final String content;
    private final UUID userId;
    private final LocalDateTime createdAt;
}

package com.example.cqrswrite.domain.feed.event.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateFeedEvent {

    private UUID id;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;

    @Builder
    public CreateFeedEvent(UUID id, String title, String content, String username, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
        this.createdAt = createdAt;
    }
}

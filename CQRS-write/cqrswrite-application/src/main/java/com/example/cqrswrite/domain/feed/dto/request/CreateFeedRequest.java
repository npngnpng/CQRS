package com.example.cqrswrite.domain.feed.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateFeedRequest {

    private final String title;
    private final String content;
}

package com.example.cqrswrite.domain.feed.event;

import com.example.cqrswrite.common.event.dto.GenericCreateEvent;
import com.example.cqrswrite.domain.feed.event.vo.CreateFeedEvent;
import com.example.cqrswrite.domain.feed.persistence.entity.FeedEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedEventProduceAdapter {

    private final FeedKafkaProducer feedKafkaProducer;

    @EventListener
    public void onCreate(GenericCreateEvent<FeedEntity> event) {
        FeedEntity feedEntity = event.getEntity();

        feedKafkaProducer.produce(
                CreateFeedEvent.builder()
                        .id(feedEntity.getId())
                        .title(feedEntity.getTitle())
                        .content(feedEntity.getContent())
                        .username(feedEntity.getUserEntity().getName())
                        .createdAt(feedEntity.getCreatedAt())
                        .build()
        );
    }
}

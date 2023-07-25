package com.example.cqrswrite.domain.feed.event;

import com.example.cqrswrite.domain.feed.event.vo.CreateFeedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedKafkaProducer {

    private final KafkaTemplate<String, CreateFeedEvent> kafkaTemplate;

    public void produce(CreateFeedEvent event) {
        kafkaTemplate.send("feed", event);
    }
}

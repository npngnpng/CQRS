package com.example.cqrswrite.domain.feed.persistence;

import com.example.cqrswrite.domain.feed.model.Feed;
import com.example.cqrswrite.domain.feed.persistence.mapper.FeedMapper;
import com.example.cqrswrite.domain.feed.persistence.repository.FeedJpaRepository;
import com.example.cqrswrite.domain.feed.spi.FeedPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedPersistenceAdapter implements FeedPort {

    private final FeedJpaRepository feedJpaRepository;
    private final FeedMapper feedMapper;

    @Override
    public void saveFeed(Feed feed) {
        feedJpaRepository.save(
                feedMapper.toEntity(feed)
        );
    }
}

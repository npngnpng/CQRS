package com.example.cqrswrite.domain.feed.spi;

import com.example.cqrswrite.domain.feed.model.Feed;

public interface CommandFeedPort {

    void saveFeed(Feed feed);
}

package com.example.cqrswrite.domain.feed.usecase;

import com.example.cqrswrite.common.annotation.UseCase;
import com.example.cqrswrite.common.spi.SecurityPort;
import com.example.cqrswrite.domain.feed.dto.request.CreateFeedRequest;
import com.example.cqrswrite.domain.feed.model.Feed;
import com.example.cqrswrite.domain.feed.spi.CommandFeedPort;
import com.example.cqrswrite.domain.user.model.User;
import com.example.cqrswrite.domain.user.spi.QueryUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class CreateFeedUseCase {

    private final CommandFeedPort commandFeedPort;
    private final SecurityPort securityPort;
    private final QueryUserPort queryUserPort;

    public void execute(CreateFeedRequest request) {
        User user = queryUserPort.queryUserById(securityPort.getCurrentUserId());

        commandFeedPort.saveFeed(
                Feed.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .userId(user.getId())
                        .build()
        );
    }
}

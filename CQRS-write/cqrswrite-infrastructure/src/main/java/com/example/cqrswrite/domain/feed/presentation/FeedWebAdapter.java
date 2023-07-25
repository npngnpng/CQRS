package com.example.cqrswrite.domain.feed.presentation;

import com.example.cqrswrite.domain.feed.dto.request.CreateFeedRequest;
import com.example.cqrswrite.domain.feed.presentation.dto.request.CreateFeedWebRequest;
import com.example.cqrswrite.domain.feed.usecase.CreateFeedUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedWebAdapter {

    private final CreateFeedUseCase createFeedUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedWebRequest request) {
        createFeedUseCase.execute(
                CreateFeedRequest.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()
        );
    }
}

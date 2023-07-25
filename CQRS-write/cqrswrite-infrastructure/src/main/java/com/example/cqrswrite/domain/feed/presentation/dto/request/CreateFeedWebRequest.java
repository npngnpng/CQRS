package com.example.cqrswrite.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CreateFeedWebRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}

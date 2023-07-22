package com.example.cqrswrite.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CreateUserWebRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String accountId;

    @NotBlank
    private String password;
}

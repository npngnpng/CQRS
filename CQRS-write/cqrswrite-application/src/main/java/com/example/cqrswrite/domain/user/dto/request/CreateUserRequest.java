package com.example.cqrswrite.domain.user.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequest {

    private final String name;
    private final String accountId;
    private final String password;
}

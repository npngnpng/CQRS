package com.example.cqrswrite.domain.user.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {

    private final String accountId;
    private final String password;
}

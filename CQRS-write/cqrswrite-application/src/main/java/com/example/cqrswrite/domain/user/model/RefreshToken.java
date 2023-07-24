package com.example.cqrswrite.domain.user.model;

import com.example.cqrswrite.common.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@Aggregate
public class RefreshToken {

    private final String accountId;
    private final String token;
    private final Integer exp;
}

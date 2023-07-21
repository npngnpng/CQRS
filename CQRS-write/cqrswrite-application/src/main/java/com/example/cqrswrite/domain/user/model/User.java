package com.example.cqrswrite.domain.user.model;

import com.example.cqrswrite.common.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder(toBuilder = true)
@Aggregate
public class User {

    private final UUID id;
    private final String name;
    private final String accountId;
    private final String password;
}

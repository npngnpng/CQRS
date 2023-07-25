package com.example.cqrswrite.domain.user.spi;

import com.example.cqrswrite.domain.user.model.User;

import java.util.UUID;

public interface QueryUserPort {

    boolean existsUserByAccountId(String accountId);

    User queryUserByAccountId(String accountId);

    User queryUserById(UUID id);
}

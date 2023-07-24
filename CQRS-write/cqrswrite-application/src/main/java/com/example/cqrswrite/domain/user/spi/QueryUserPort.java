package com.example.cqrswrite.domain.user.spi;

import com.example.cqrswrite.domain.user.model.User;

public interface QueryUserPort {

    boolean existsUserByAccountId(String accountId);

    User queryUserByAccountId(String accountId);
}

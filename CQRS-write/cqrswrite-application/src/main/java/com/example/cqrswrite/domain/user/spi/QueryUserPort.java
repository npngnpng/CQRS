package com.example.cqrswrite.domain.user.spi;

public interface QueryUserPort {

    boolean existsUserByAccountId(String accountId);
}

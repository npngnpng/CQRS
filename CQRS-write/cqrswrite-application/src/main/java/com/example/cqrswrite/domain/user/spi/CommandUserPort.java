package com.example.cqrswrite.domain.user.spi;

import com.example.cqrswrite.domain.user.model.User;

public interface CommandUserPort {

    User saveUser(User user);
}

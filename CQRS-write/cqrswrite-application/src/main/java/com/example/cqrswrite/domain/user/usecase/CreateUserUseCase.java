package com.example.cqrswrite.domain.user.usecase;

import com.example.cqrswrite.common.annotation.UseCase;
import com.example.cqrswrite.common.spi.PasswordEncoderPort;
import com.example.cqrswrite.common.spi.SecurityPort;
import com.example.cqrswrite.domain.user.dto.request.CreateUserRequest;
import com.example.cqrswrite.domain.user.exception.UserException;
import com.example.cqrswrite.domain.user.model.User;
import com.example.cqrswrite.domain.user.spi.CommandUserPort;
import com.example.cqrswrite.domain.user.spi.QueryUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class CreateUserUseCase {

    private final CommandUserPort commandUserPort;
    private final QueryUserPort queryUserPort;
    private final PasswordEncoderPort passwordEncoderPort;

    public void execute(CreateUserRequest request) {
        if (queryUserPort.existsUserByAccountId(request.getAccountId())) {
            throw UserException.USER_ALREADY_EXISTS;
        }

        commandUserPort.saveUser(
                User.builder()
                        .name(request.getName())
                        .accountId(request.getAccountId())
                        .password(passwordEncoderPort.encodePassword(request.getPassword()))
                        .build()
        );
    }
}

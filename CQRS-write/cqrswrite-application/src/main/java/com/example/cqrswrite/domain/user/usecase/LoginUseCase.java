package com.example.cqrswrite.domain.user.usecase;

import com.example.cqrswrite.common.annotation.UseCase;
import com.example.cqrswrite.common.spi.JwtPort;
import com.example.cqrswrite.common.spi.PasswordEncoderPort;
import com.example.cqrswrite.domain.user.dto.request.LoginRequest;
import com.example.cqrswrite.domain.user.dto.response.TokenResponse;
import com.example.cqrswrite.domain.user.exception.UserException;
import com.example.cqrswrite.domain.user.model.User;
import com.example.cqrswrite.domain.user.spi.QueryUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class LoginUseCase {

    private final QueryUserPort queryUserPort;
    private final PasswordEncoderPort passwordEncoderPort;
    private final JwtPort jwtPort;

    public TokenResponse execute(LoginRequest request) {
        User user = queryUserPort.queryUserByAccountId(request.getAccountId());

        if (!passwordEncoderPort.matchesPassword(request.getPassword(), user.getPassword())) {
            throw UserException.INVALID_PASSWORD;
        }

        return jwtPort.generateTokens(user.getId().toString());
    }
}

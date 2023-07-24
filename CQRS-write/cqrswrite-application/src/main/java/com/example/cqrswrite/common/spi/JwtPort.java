package com.example.cqrswrite.common.spi;

import com.example.cqrswrite.domain.user.dto.response.TokenResponse;

public interface JwtPort {

    TokenResponse generateTokens(String userId);
}

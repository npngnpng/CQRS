package com.example.cqrswrite.common.security.jwt;

import com.example.cqrswrite.common.spi.JwtPort;
import com.example.cqrswrite.domain.user.dto.response.TokenResponse;
import com.example.cqrswrite.domain.user.persistence.entity.RefreshTokenEntity;
import com.example.cqrswrite.domain.user.persistence.repository.RefreshTokenRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenAdapter implements JwtPort {

    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public TokenResponse generateTokens(String accountId) {
        String accessToken = generateAccessToken(accountId);
        String refreshToken = generateRefreshToken(accountId);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .accessExpiresAt(LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(refreshToken)
                .refreshExpiresAt(LocalDateTime.now().plusSeconds(jwtProperties.getRefreshExp()))
                .build();
    }

    private String generateAccessToken(String accountId) {
        return generateToken(TokenType.ACCESS, jwtProperties.getAccessExp(), accountId);
    }

    private String generateRefreshToken(String accountId) {
        String token = generateToken(TokenType.REFRESH, jwtProperties.getRefreshExp(), accountId);
        refreshTokenRepository.save(
                RefreshTokenEntity.builder()
                        .accountId(accountId)
                        .token(token)
                        .exp(jwtProperties.getRefreshExp())
                        .build()
        );
        return token;
    }

    private String generateToken(TokenType type, Integer exp, String accountId) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .setSubject(accountId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (exp * 1000)))
                .claim("type", type.name())
                .claim("exp", exp)
                .compact();
    }
}

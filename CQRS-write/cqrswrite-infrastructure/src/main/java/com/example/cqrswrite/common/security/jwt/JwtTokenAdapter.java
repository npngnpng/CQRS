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
    public TokenResponse generateTokens(String userId) {
        String accessToken = generateAccessToken(userId);
        String refreshToken = generateRefreshToken(userId);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .accessExpiresAt(LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(refreshToken)
                .refreshExpiresAt(LocalDateTime.now().plusSeconds(jwtProperties.getRefreshExp()))
                .build();
    }

    private String generateAccessToken(String userId) {
        System.out.println(jwtProperties.getAccessExp());
        return generateToken(TokenType.ACCESS, jwtProperties.getAccessExp(), userId);
    }

    private String generateRefreshToken(String userId) {
        String token = generateToken(TokenType.REFRESH, jwtProperties.getRefreshExp(), userId);
        refreshTokenRepository.save(
                RefreshTokenEntity.builder()
                        .id(userId)
                        .token(token)
                        .exp(jwtProperties.getRefreshExp())
                        .build()
        );
        return token;
    }

    private String generateToken(TokenType type, Integer exp, String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (exp * 1000)))
                .claim("type", type.name())
                .compact();
    }
}

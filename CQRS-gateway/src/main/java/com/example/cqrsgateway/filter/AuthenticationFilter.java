package com.example.cqrsgateway.filter;

import com.example.cqrsgateway.exception.ExpiredTokenException;
import com.example.cqrsgateway.exception.InvalidTokenException;
import com.example.cqrsgateway.exception.TokenNotFoundException;
import com.example.cqrsgateway.jwt.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private final JwtProperties jwtProperties;

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            String bearerToken = Optional.ofNullable(
                    request.getHeaders().get(HttpHeaders.AUTHORIZATION)
            ).orElseThrow(() -> TokenNotFoundException.EXCEPTION).get(0);
            String token = bearerToken.replace(jwtProperties.getPrefix(), "");

            Claims claims = getClaims(token);

            ServerHttpRequest modifiedRequest = request.mutate()
                    .header("User-Id", claims.getSubject())
                    .build();

            return chain.filter(
                    exchange.mutate()
                            .request(modifiedRequest)
                            .build()
            );
        };
    }

    public static class Config {}

    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            e.printStackTrace();
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public AuthenticationFilter(JwtProperties jwtProperties) {
        super(AuthenticationFilter.Config.class);
        this.jwtProperties = jwtProperties;
    }
}

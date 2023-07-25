package com.example.cqrsgateway.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConfigurationProperties("jwt")
@ConstructorBinding
public class JwtProperties {

    private final String secret;
    private final String prefix;

    public JwtProperties(String secret, String prefix) {
        this.secret = secret;
        this.prefix = prefix;
    }
}

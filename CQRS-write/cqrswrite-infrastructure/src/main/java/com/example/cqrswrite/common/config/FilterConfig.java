package com.example.cqrswrite.common.config;

import com.example.cqrswrite.common.error.GlobalExceptionFilter;
import com.example.cqrswrite.common.security.AuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity http) {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter();
        GlobalExceptionFilter globalExceptionFilter = new GlobalExceptionFilter(objectMapper);
        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(globalExceptionFilter, AuthenticationFilter.class);
    }
}

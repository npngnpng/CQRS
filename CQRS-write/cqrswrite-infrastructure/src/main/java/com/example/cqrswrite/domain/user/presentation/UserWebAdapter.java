package com.example.cqrswrite.domain.user.presentation;

import com.example.cqrswrite.domain.user.dto.request.CreateUserRequest;
import com.example.cqrswrite.domain.user.dto.request.LoginRequest;
import com.example.cqrswrite.domain.user.dto.response.TokenResponse;
import com.example.cqrswrite.domain.user.presentation.dto.request.CreateUserWebRequest;
import com.example.cqrswrite.domain.user.presentation.dto.request.LoginWebRequest;
import com.example.cqrswrite.domain.user.usecase.CreateUserUseCase;
import com.example.cqrswrite.domain.user.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserWebAdapter {

    private final CreateUserUseCase createUserUseCase;
    private final LoginUseCase loginUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void createUser(@RequestBody @Valid CreateUserWebRequest request) {
        createUserUseCase.execute(
                CreateUserRequest.builder()
                        .name(request.getName())
                        .accountId(request.getAccountId())
                        .password(request.getPassword())
                        .build()
        );
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginWebRequest request) {
        return loginUseCase.execute(
                LoginRequest.builder()
                        .accountId(request.getAccountId())
                        .password(request.getPassword())
                        .build()
        );
    }
}

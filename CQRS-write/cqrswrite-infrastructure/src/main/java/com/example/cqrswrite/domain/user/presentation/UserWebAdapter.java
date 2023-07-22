package com.example.cqrswrite.domain.user.presentation;

import com.example.cqrswrite.domain.user.dto.request.CreateUserRequest;
import com.example.cqrswrite.domain.user.presentation.dto.request.CreateUserWebRequest;
import com.example.cqrswrite.domain.user.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserWebAdapter {

    private final CreateUserUseCase createUserUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void createUser(CreateUserWebRequest request) {
        createUserUseCase.execute(
                CreateUserRequest.builder()
                        .name(request.getName())
                        .accountId(request.getAccountId())
                        .password(request.getPassword())
                        .build()
        );
    }
}

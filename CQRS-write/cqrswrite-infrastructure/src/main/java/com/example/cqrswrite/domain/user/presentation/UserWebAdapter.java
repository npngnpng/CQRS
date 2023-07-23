package com.example.cqrswrite.domain.user.presentation;

import com.example.cqrswrite.domain.user.dto.request.CreateUserRequest;
import com.example.cqrswrite.domain.user.presentation.dto.request.CreateUserWebRequest;
import com.example.cqrswrite.domain.user.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void createUser(@RequestBody @Valid CreateUserWebRequest request) {
        System.out.println(request.getName());
        System.out.println(request.getAccountId());
        System.out.println(request.getPassword());
        createUserUseCase.execute(
                CreateUserRequest.builder()
                        .name(request.getName())
                        .accountId(request.getAccountId())
                        .password(request.getPassword())
                        .build()
        );
    }
}

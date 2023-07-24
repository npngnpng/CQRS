package com.example.cqrswrite.domain.user.exception.error;

import com.example.cqrswrite.common.error.ErrorProperty;
import com.example.cqrswrite.common.error.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorProperty {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),

    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "Invalid Password"),

    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "User Already Exists");

    private final HttpStatus status;
    private final String message;
}

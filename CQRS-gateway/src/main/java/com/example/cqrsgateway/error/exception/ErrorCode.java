package com.example.cqrsgateway.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_TOKEN(401, "Token Expired"),
    INVALID_TOKEN(401, "Invalid Token"),

    TOKEN_NOT_FOUND(404, "Token Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final Integer status;
    private final String message;
}

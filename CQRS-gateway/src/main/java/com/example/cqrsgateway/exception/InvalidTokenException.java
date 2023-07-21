package com.example.cqrsgateway.exception;

import com.example.cqrsgateway.error.exception.BaseException;
import com.example.cqrsgateway.error.exception.ErrorCode;

public class InvalidTokenException extends BaseException {

    public static final BaseException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}

package com.example.cqrsgateway.exception;

import com.example.cqrsgateway.error.exception.BaseException;
import com.example.cqrsgateway.error.exception.ErrorCode;

public class TokenNotFoundException extends BaseException {

    public static final BaseException EXCEPTION = new TokenNotFoundException();

    private TokenNotFoundException() {
        super(ErrorCode.TOKEN_NOT_FOUND);
    }
}

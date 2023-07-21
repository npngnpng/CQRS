package com.example.cqrsgateway.exception;

import com.example.cqrsgateway.error.exception.BaseException;
import com.example.cqrsgateway.error.exception.ErrorCode;

public class ExpiredTokenException extends BaseException {

    public static final BaseException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}

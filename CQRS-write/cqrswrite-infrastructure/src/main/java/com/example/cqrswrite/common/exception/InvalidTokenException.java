package com.example.cqrswrite.common.exception;

import com.example.cqrswrite.common.error.BaseException;
import com.example.cqrswrite.common.error.exception.GlobalErrorCode;

public class InvalidTokenException extends BaseException {
    public static final BaseException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(GlobalErrorCode.INVALID_TOKEN);
    }
}

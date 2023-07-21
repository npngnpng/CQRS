package com.example.cqrswrite.common.exception;

import com.example.cqrswrite.common.error.BaseException;
import com.example.cqrswrite.common.error.exception.GlobalErrorCode;

public class ExpiredTokenException extends BaseException {
    public static final BaseException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(GlobalErrorCode.EXPIRED_TOKEN);
    }
}

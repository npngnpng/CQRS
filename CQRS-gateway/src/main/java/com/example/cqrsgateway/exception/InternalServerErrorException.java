package com.example.cqrsgateway.exception;

import com.example.cqrsgateway.error.exception.BaseException;
import com.example.cqrsgateway.error.exception.ErrorCode;

public class InternalServerErrorException extends BaseException {

    public static final BaseException EXCEPTION = new InternalServerErrorException();

    private InternalServerErrorException() {
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}

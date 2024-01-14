package com.example.cqrswrite.domain.user.exception;

import com.example.cqrswrite.common.error.BaseException;
import com.example.cqrswrite.common.error.ErrorProperty;
import com.example.cqrswrite.domain.user.exception.error.UserErrorCode;

public class UserException extends BaseException {

    public static final BaseException USER_ALREADY_EXISTS = new UserException(UserErrorCode.USER_ALREADY_EXISTS);

    public static final BaseException USER_NOT_FOUND = new UserException(UserErrorCode.USER_NOT_FOUND);
    public static final BaseException INVALID_PASSWORD = new UserException(UserErrorCode.INVALID_PASSWORD);

    private UserException(ErrorProperty errorProperty) {
        super(errorProperty);
    }
}

package com.example.cqrsread.common.exception

import com.example.cqrsread.common.error.BaseException
import com.example.cqrsread.common.error.GlobalErrorCode

object InternalServerErrorException: BaseException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
)
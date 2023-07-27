package com.example.cqrsread.common.error

abstract class BaseException(
    val errorProperty: ErrorProperty
) : RuntimeException() {
}
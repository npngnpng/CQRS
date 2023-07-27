package com.example.cqrsread.common.error

data class ErrorResponse(
    val message: String,
    val status: Int,
)

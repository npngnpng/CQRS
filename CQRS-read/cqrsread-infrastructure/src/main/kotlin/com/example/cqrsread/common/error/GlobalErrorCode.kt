package com.example.cqrsread.common.error

enum class GlobalErrorCode(
    override val status: Int,
    override val message: String
): ErrorProperty {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}
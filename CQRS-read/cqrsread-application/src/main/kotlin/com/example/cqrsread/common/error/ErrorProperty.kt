package com.example.cqrsread.common.error

interface ErrorProperty {

    val message: String
    val status: Int
}
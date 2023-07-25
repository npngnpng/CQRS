package com.example.cqrsread

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CqrsReadApplication

fun main(args: Array<String>) {
    runApplication<CqrsReadApplication>(*args)
}

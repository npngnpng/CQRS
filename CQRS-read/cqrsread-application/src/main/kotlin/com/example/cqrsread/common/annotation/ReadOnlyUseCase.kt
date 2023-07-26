package com.example.cqrsread.common.annotation

import org.springframework.transaction.annotation.Transactional

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE)
@Transactional(readOnly = true)
annotation class ReadOnlyUseCase()

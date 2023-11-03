package com.example.cqrsread.common.config

import com.example.cqrsread.common.annotation.ReadOnlyUseCase
import com.example.cqrsread.common.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.example.cqrsread"],
    includeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            classes = [UseCase::class, ReadOnlyUseCase::class]
        )
    ]
)
class ComponentScanConfig
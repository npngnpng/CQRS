package com.example.cqrswrite.common.config;

import com.example.cqrswrite.common.annotation.ReadOnlyUseCase;
import com.example.cqrswrite.common.annotation.UseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"com.example.cqrswrite"},
        includeFilters = {
                @Filter(
                        type = FilterType.ANNOTATION,
                        classes = {
                                UseCase.class,
                                ReadOnlyUseCase.class
                        }
                )
        }
)
public class ComponentScanConfig {
}

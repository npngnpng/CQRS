package com.example.cqrswrite.common.error.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class ValidationErrorResponse {
    private final String status;
    private final Map<String, String> error;
}

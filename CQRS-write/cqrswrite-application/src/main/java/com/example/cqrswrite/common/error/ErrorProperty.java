package com.example.cqrswrite.common.error;

public interface ErrorProperty {

    HttpStatus getStatus();

    String getMessage();
}

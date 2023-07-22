package com.example.cqrswrite.common.spi;

public interface SecurityPort {

    String encodePassword(String password);
}

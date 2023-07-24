package com.example.cqrswrite.common.spi;

public interface PasswordEncoderPort {

    String encodePassword(String password);

    boolean matchesPassword(String rawPassword, String encodedPassword);
}
